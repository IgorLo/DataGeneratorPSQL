package ru.igorlo

import ru.igorlo.Entities.City
import ru.igorlo.Entities.Item
import ru.igorlo.Entities.Location
import ru.igorlo.Entities.Skill
import ru.igorlo.Utilities.printResultSet
import java.util.*

var conScanner = Scanner(System.`in`)

private val connector: DBConnector = DBConnector()

fun main(args: Array<String>) {
    println(Constants.TEXT_INTRO)
//    val first = getUserIntParameter("first parameter (int):")
//    val second = getUserIntParameter("second parameter (int):")
//    val third = getUserIntParameter("third parameter (int):")

//    print(StatementBuilder.insertColumnsInTable("TABLE", listOf("first", "second", "third")))

    connector.newConnection()

//    val selectResult = connector.getResultSetOfSelect("characters", 5)
//    printResultSet(selectResult, 15)

//    printResultSet(connector.getResultSetOfSelect("items"))
//    connector.insertDataInTable("items", Item.generateItems(5))
//
//    printResultSet(connector.getResultSetOfSelect("skills"))
//    connector.insertDataInTable("skills", Skill.generateSkills(5))
//    printResultSet(connector.getResultSetOfSelect("skills"))
//
//    printResultSet(connector.getResultSetOfSelect("locations"))
//    connector.insertDataInTable("locations", Location.generateLocations(2))
//    printResultSet(connector.getResultSetOfSelect("locations"))
//
    printResultSet(connector.getResultSetOfSelect("cities"))
    connector.insertDataInTable("cities", City.generateCities(3))
    printResultSet(connector.getResultSetOfSelect("cities"))

}
