package ru.igorlo

import org.slf4j.LoggerFactory
import java.lang.StringBuilder
import java.sql.ResultSet
import java.util.*
import kotlin.random.Random

object Utilities {

    private val logger = LoggerFactory.getLogger(Utilities::class.java)

    fun printResultSet(resultSet: ResultSet, valueMaxSize: Int = 10) {
        logger.info("Printing ResultSet")
        val metaData = resultSet.metaData
        println("\n".padEnd(metaData.columnCount * (valueMaxSize + 1), '-'))
        for (i in 1..metaData.columnCount) {
            System.out.print(metaData.getColumnName(i).take(valueMaxSize).padEnd(valueMaxSize))
            if (i < metaData.columnCount)
                print('|')
        }
        println("\n".padEnd(metaData.columnCount * (valueMaxSize + 1), '-'))
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
        println("\n".padEnd(metaData.columnCount * (valueMaxSize + 1), '-'))
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

    fun generateNpcName(shortName: Boolean = false, randomizer: Random = Random.Default): String {
        val stringBuilder = StringBuilder()

        //firstname
        stringBuilder
            .append(Constants.NAMES_FIRSTNAME_FIRSTHALF.random())
            .append(Constants.NAMES_FIRSTNAME_SECONDHALF.random())

        //secondname
        if (randomizer.nextDouble() < 0.6)
            stringBuilder.append(" ").append(Constants.NAMES_SECOND_NAME.random())

        //postfix
        if (randomizer.nextDouble() < 0.6)
            stringBuilder.append(" ").append(Constants.NAMES_AFTER_NAME.random())

        return stringBuilder.toString()
    }

    fun generateItemName(randomizer: Random = Random.Default): String {
        return Constants.GEN_ITEMS_NAMES.random(randomizer)
    }

    fun generateSkillName(randomizer: Random = Random.Default): String {
        return Constants.GEN_SKILLS_NAMES.random(randomizer)
    }

    fun generateLocationName(randomizer: Random = Random.Default): String {
        return Constants.GEN_LOCATIONS_NAMES.random(randomizer)
    }

    fun generateCityName(randomizer: Random = Random.Default): String {
        return Constants.GEN_CITIES_NAMES.random(randomizer)
    }

}