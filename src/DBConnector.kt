import org.postgresql.util.PSQLException
import org.slf4j.LoggerFactory
import java.lang.StringBuilder
import java.sql.*
import kotlin.system.exitProcess

class DBConnector {

    private val logger = LoggerFactory.getLogger(DBConnector::class.java)

    private val DB_NAME_DEFAULT = "rpg_game"
    private val DB_USER_DEFAULT = "94405"
    private val DB_PASS_DEFAULT = "440533"
    private val HOST_DEFAULT = "localhost"
    private val PORT_DEFAULT = 5432

    private var connection : Connection? = null

    fun newConnection() {
        logger.info("Creating new connection with default parameters")
        newConnection(
            DB_NAME_DEFAULT,
            DB_USER_DEFAULT,
            DB_PASS_DEFAULT,
            HOST_DEFAULT,
            PORT_DEFAULT
        )
    }

    fun newConnection(db_name: String, db_user: String, db_pass: String, host: String, port: Int) {
        logger.info("Creating new connection to $db_name via $db_user user")
        if (connection != null){
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

    fun getResultSetOfSelect(tableName : String, vararg fields : String) : ResultSet {
        logger.info("Executing SELECT from table $tableName by fields")
        if (connection == null){
            logger.error("Cannot execute SELECT, because there's no connection to DB")
            exitProcess(1)
        }
        logger.info("Creating statement")
        val statement = connection!!.createStatement()
        try {
            logger.info("Executing query")
            return statement.executeQuery(StatementBuilder.selectFieldsFromTable(tableName, *fields))
        } catch (e : PSQLException) {
            logger.error("Error while executing SELECT!")
        }
        exitProcess(1)
    }

}