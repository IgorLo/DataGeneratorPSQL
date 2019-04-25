import java.io.IOException
import java.util.*

var conScanner = Scanner(System.`in`)

private val connector : DBConnector = DBConnector()

fun main(args: Array<String>) {
    println(
        "Welcome to the data generator for Postgres DB. This program will\n" +
                "ask to input some parameters required for data generation. After\n" +
                "collecting all required data it will connect to selected DB and\n" +
                "fill tables with random data."
    )
//    val first = getUserIntParameter("first parameter (int):")
//    val second = getUserIntParameter("second parameter (int):")
//    val third = getUserIntParameter("third parameter (int):")

    connector.newConnection()

}

fun getUserIntParameter(text: String): Int {
    var parameter: Int? = null
    while (parameter == null) {
        print("$text ")
        try {
            parameter = conScanner.nextInt()
        } catch (e : InputMismatchException){
            print("Неприёмлимое значение\n")
            conScanner = Scanner(System.`in`)
        }
    }
    return parameter
}
