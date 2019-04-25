import org.slf4j.LoggerFactory
import java.sql.ResultSet
import java.util.*

class Utilities {

    companion object {

        private val logger = LoggerFactory.getLogger(Utilities::class.java)

        fun printResultSet(resultSet: ResultSet, valueMaxSize: Int = 10) {
            logger.info("Printing ResultSet")
            val metaData = resultSet.metaData
            for (i in 1..metaData.columnCount) {
                System.out.print(metaData.getColumnName(i).take(valueMaxSize).padEnd(valueMaxSize))
                if (i < metaData.columnCount)
                    print('|')
            }
            println("\n".padEnd(metaData.columnCount * valueMaxSize, '-'))
            while (resultSet.next()) {
                for (i in 1..metaData.columnCount) {
                    if (i > 1) print("|")
                    val columnValue =
                        if (resultSet.getString(i) == null)
                            "".padEnd(valueMaxSize)
                        else
                            resultSet.getString(i).take(valueMaxSize).padEnd(valueMaxSize)
                    print(columnValue)
                }
                println("")
            }
        }

        fun getUserIntParameter(text: String): Int {
            logger.info("Getting INT from user")
            var parameter: Int? = null
            while (parameter == null) {
                print("$text ")
                try {
                    parameter = conScanner.nextInt()
                } catch (e: InputMismatchException) {
                    print("Неприёмлимое значение\n")
                    conScanner = Scanner(System.`in`)
                }
            }
            return parameter
        }
    }

}