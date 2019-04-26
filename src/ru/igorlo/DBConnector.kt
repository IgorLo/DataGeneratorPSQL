package ru.igorlo

import org.postgresql.util.PSQLException
import org.slf4j.LoggerFactory
import ru.igorlo.Entities.DBEntity
import java.sql.*
import kotlin.system.exitProcess

class DBConnector {
    private val logger = LoggerFactory.getLogger(DBConnector::class.java)
    private var connection: Connection? = null

    fun newConnection(
        db_name: String = Constants.DB_NAME_DEFAULT,
        db_user: String = Constants.DB_USER_DEFAULT,
        db_pass: String = Constants.DB_PASS_DEFAULT,
        host: String = Constants.DB_HOST_DEFAULT,
        port: Int = Constants.DB_PORT_DEFAULT
    ) {
        logger.info("Creating new connection to $db_name via $db_user user")
        if (connection != null) {
            try {
                logger.info("Closing old connection if present")
                connection?.close()
            } catch (e: PSQLException) {
                logger.warn("Couldn't carefully close old DB connection, but didn't crash")
            }
        } else {
            logger.info("Old connection was NULL, not even trying to close it...")
        }
        connection = DriverManager.getConnection("jdbc:postgresql://$host:$port/$db_name", db_user, db_pass)
    }

    fun getResultSetOfSelect(tableName: String, limit: Int = 0, vararg fields: String): ResultSet {
        logger.info("Executing SELECT from table $tableName by fields")
        if (connection == null) {
            logger.error("Cannot execute SELECT, because there's no connection to DB")
            exitProcess(1)
        }
        logger.info("Creating statement")
        val statement = connection!!.createStatement()
        try {
            logger.info("Executing query")
            return statement.executeQuery(
                StatementBuilder.selectFieldsFromTable(
                    tableName,
                    limit,
                    *fields
                )
            )
        } catch (e: PSQLException) {
            logger.error("Error while executing SELECT!")
        }
        exitProcess(1)
    }

    fun insertDataInTable(tableName: String, data: Collection<DBEntity>) {
        logger.info("Trying to insert data in table")
        val listOfFields = data.first().getValuesMap().keys
        val statement = StatementBuilder.insertColumnsInTable(tableName, listOfFields)
        val preparedStatement: PreparedStatement
        try {
            logger.info("Preparing statement")
            preparedStatement = connection!!.prepareStatement(statement)
            logger.info("Prepared successfully!")
        } catch (e: PSQLException) {
            logger.error("Oops! Could not prepare statement - something wrong with connection!")
            e.printStackTrace()
            exitProcess(1)
        }

        var count: Int
        logger.info("Adding data to statement...")
        for (element in data) {
            count = 1
            for (entry in element.getValuesMap().entries) {
                when (entry.value) {
                    is String -> preparedStatement.setString(count, entry.value as String)
                    is Int -> preparedStatement.setInt(count, entry.value as Int)
                    is Boolean -> preparedStatement.setBoolean(count, entry.value as Boolean)
                    is Timestamp -> preparedStatement.setTimestamp(count, entry.value as Timestamp)
                    is Double -> preparedStatement.setDouble(count, entry.value as Double)
                }
                count++
            }
            if (element != data.last())
                preparedStatement.addBatch()
        }
        logger.info("Successfully added " + data.size + " elements to statement")
        try {
            logger.info("Executing prepared statement")
            preparedStatement.executeBatch()
            logger.info("Success!")
        } catch (e: PSQLException) {
            logger.error("Oops! Could not execute statement! Something went wrong!")
            e.printStackTrace()
            exitProcess(1)
        }
    }
}