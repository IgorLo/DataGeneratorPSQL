package ru.igorlo

import ru.igorlo.Entities.*
import ru.igorlo.Utilities.printResultSet
import java.util.*

var conScanner = Scanner(System.`in`)

private val connector: DBConnector = DBConnector()

fun main(args: Array<String>) {
    println(Constants.TEXT_INTRO)
//    val first = getUserIntParameter("first parameter (int):")
//    val second = getUserIntParameter("second parameter (int):")
//    val third = getUserIntParameter("third parameter (int):")

    connector.newConnection()


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
//
//    printResultSet(connector.getResultSetOfSelect("npcs"), 20)
//    connector.insertDataInTable("npcs", NPC.generateNpcs(connector.getListOfIds("locations"), 10))
//    printResultSet(connector.getResultSetOfSelect("npcs"), 20)


//    printResultSet(connector.getResultSetOfSelect("connections"), 20)
//    connector.cleanTable("connections")
//    printResultSet(connector.getResultSetOfSelect("connections"), 20)
//    connector.insertDataInTable(
//        "connections",
//        MapConnection.generateConnections(
//            connector.getListOfIds("locations"),
//            100
//        )
//    )
//    printResultSet(connector.getResultSetOfSelect("connections"), 20)

//    printResultSet(connector.getResultSetOfSelect("characters"), 20)
//    connector.insertDataInTable(
//        "characters", PlayerCharacter.generateCharacters(
//            connector.getListOfIds("clans"),
//            connector.getListOfIds("npcs"),
//            connector.getListOfIds("locations"),
//            50
//        )
//    )
//    printResultSet(connector.getResultSetOfSelect("characters"), 20)

//    connector.setFieldToRandomId("locations", "cities", "fk_city", "locations.name != cities.name")
//    connector.setFieldToRandomId("cities", "characters", "fk_mayor", "cities.name != characters.name")
//    connector.setFieldToRandomId("cities", "clans", "fk_leading_clan", "cities.name != clans.name")
//    connector.setFieldToRandomId("characters", "npcs", "fk_worst_enemy", "characters.name != npcs.name")
//    connector.setFieldToRandomId("characters", "locations", "fk_location", "characters.name != locations.name")
//    connector.setFieldToRandomId("characters", "clans", "fk_clan", "characters.name != clan.name")
//    connector.setFieldToRandomId("clans", "characters", "fk_leader", "fk_clan = clans.id")

//    printResultSet(connector.getResultSetOfSelect("locations"))
//    printResultSet(connector.getResultSetOfSelect("cities"))
//    printResultSet(connector.getResultSetOfSelect("characters"), 20)
//    printResultSet(connector.getResultSetOfSelect("clans"), 20)

//    connector.cleanTable("link_char_item")
//    connector.addLinks("link_char_item", "fk_char", "fk_item", "characters", "items", 1000)
//    printResultSet(connector.getResultSetOfSelect("link_char_item", orderBy = "fk_char"))

//    connector.cleanTable("link_npc_item")
//    connector.addLinks("link_npc_item", "fk_npc", "fk_item", "npcs", "items", 1000)
//    printResultSet(connector.getResultSetOfSelect("link_npc_item", orderBy = "fk_npc"))

//    connector.cleanTable("link_char_skill")
//    connector.addLinks("link_char_skill", "fk_char", "fk_skill", "characters", "skills", 200)
//    printResultSet(connector.getResultSetOfSelect("link_char_skill", orderBy = "fk_char"))

//    connector.cleanTable("link_npc_skill")
//    connector.addLinks("link_npc_skill", "fk_npc", "fk_skill", "npcs", "skills", 200)
//    printResultSet(connector.getResultSetOfSelect("link_npc_skill", orderBy = "fk_npc"))

    printResultSet(connector.getResultSetOfSelect("npc_fights", orderBy = "kill_time"), 20)
    connector.cleanTable("npc_fights")
    connector.insertDataInTable(
        "npc_fights", NpcFight.generateNpcFights(
            connector.getListOfIds("npcs"),
            connector.getListOfIds("characters"),
            connector.getListOfIds("locations"),
            1000
        )
    )
    printResultSet(connector.getResultSetOfSelect("npc_fights", orderBy = "kill_time"), 20)
}
