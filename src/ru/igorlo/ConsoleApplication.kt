package ru.igorlo

import ru.igorlo.Entities.City
import ru.igorlo.Entities.Clan
import ru.igorlo.Entities.MapConnection
import ru.igorlo.Entities.NPC
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
//    printResultSet(connector.getResultSetOfSelect("cities"))
//    connector.insertDataInTable("cities", City.generateCities(3))
//    printResultSet(connector.getResultSetOfSelect("cities"))

//    printResultSet(connector.getResultSetOfSelect("clans"), 20)
//    connector.insertDataInTable("clans", Clan.generateClans(10))
//    printResultSet(connector.getResultSetOfSelect("clans"), 20)

//    printResultSet(connector.getResultSetOfSelect("npcs"), 20)
//    connector.insertDataInTable("npcs", NPC.generateNpcs(10))
//    printResultSet(connector.getResultSetOfSelect("npcs"), 20)


    printResultSet(connector.getResultSetOfSelect("connections"), 20)
    connector.cleanTable("connections")
    printResultSet(connector.getResultSetOfSelect("connections"), 20)
    connector.insertDataInTable(
        "connections",
        MapConnection.generateConnections(
            connector.getListOfIds("locations"),
            100
        )
    )
    printResultSet(connector.getResultSetOfSelect("connections"), 20)

}
