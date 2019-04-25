import org.slf4j.LoggerFactory
import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

class DBConnector {

    private val logger = LoggerFactory.getLogger(DBConnector::class.java)

    val DB_NAME_DEFAULT = "rpg_game"
    val DB_USER_DEFAULT = "94405"
    val DB_PASS_DEFAULT = "440533"
    val HOST_DEFAULT = "localhost"
    val PORT_DEFAULT = 5432

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
            } catch (e: SQLException) {
                logger.warn("Couldn't carefully close old DB connection, but didn't crash")
            }
        } else {
            logger.info("Old connection was NULL, not even trying to close it...")
        }
        connection = DriverManager.getConnection("jdbc:postgresql://$host:$port/$db_name", db_user, db_pass)
    }

}