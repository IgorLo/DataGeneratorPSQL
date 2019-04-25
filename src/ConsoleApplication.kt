import Utilities.Companion.getUserIntParameter
import Utilities.Companion.printResultSet

import java.util.*

var conScanner = Scanner(System.`in`)

private val connector: DBConnector = DBConnector()

fun main(args: Array<String>) {
    println(
        "\n\n" +
                "\t----------------------------------------------------------------\n" +
                "\tWelcome to the data generator for Postgres DB. This program will\n" +
                "\task to input some parameters required for data generation. After\n" +
                "\tcollecting all required data it will connect to selected DB and\n" +
                "\tfill tables with random data.\n\n" +
                "\t\t   Created by Igor Lopatinskiy for university project.\n" +
                "\t\t\t\t\t\t\t   Spring 2019\n" +
                "\t\t\t------------------------------------------------\n\n"
    )
//    val first = getUserIntParameter("first parameter (int):")
//    val second = getUserIntParameter("second parameter (int):")
//    val third = getUserIntParameter("third parameter (int):")

    connector.newConnection()

    val selectResult = connector.getResultSetOfSelect("characters")
    printResultSet(selectResult, 15)

}
