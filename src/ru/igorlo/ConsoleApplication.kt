package ru.igorlo

import ru.igorlo.Entities.*
import ru.igorlo.Utilities.getUserIntParameter
import ru.igorlo.Utilities.printResultSet
import java.util.*

var conScanner = Scanner(System.`in`)
private val connector: DBConnector = DBConnector()

fun main() {
    println(Constants.TEXT_INTRO)

    val customHost: String
    val customPort: Int
    val customDBName: String
    val customUser: String
    val customPass: String

    val shouldCleanUp = Utilities.getUserBooleanParameter("You want to clean up present data?")
    val customConnectionParams =
        Utilities.getUserBooleanParameter("Want to customize connection parameters? (No for default)")
    if (customConnectionParams) {
        customHost = Utilities.getUserStringParameter("DB host?")
        customPort = getUserIntParameter("DB port?")
        customDBName = Utilities.getUserStringParameter("DB name?")
        customUser = Utilities.getUserStringParameter("Username?")
        customPass = Utilities.getUserStringParameter("Password?")
        connector.newConnection(customDBName, customUser, customPass, customHost, customPort)
    } else {
        connector.newConnection()
    }

    val isCustomParameters =
        Utilities.getUserBooleanParameter("You want to set generation parameters? (No for default)")
    if (isCustomParameters) {
        Constants.GEN_ITEMS_QUANTITY = getUserIntParameter("Items quantity?")
        Constants.GEN_SKILLS_QUANTITY = getUserIntParameter("Skills quantity?")
        Constants.GEN_LOCATIONS_QUANTITY = getUserIntParameter("Locations quantity?")
        Constants.GEN_CITIES_QUANTITY = getUserIntParameter("Cities quantity?")
        Constants.GEN_CLANS_QUANTITY = getUserIntParameter("Clans quantity?")
        Constants.GEN_NPCS_QUANTITY = getUserIntParameter("Npcs quantity?")
        Constants.GEN_CONNECTIONS_QUANTITY = getUserIntParameter("Map connections quantity?")
        Constants.GEN_CHARACTERS_QUANTITY = getUserIntParameter("Characters quantity?")
        Constants.GEN_NPC_FIGHTS_QUANTITY = getUserIntParameter("Npc fights quantity?")
        Constants.GEN_PLAYER_FIGHTS_QUANTITY = getUserIntParameter("Player fights quantity?")
    }

    val limit = getUserIntParameter("Limit display for tables? (0 for all data)")

    val startTime = System.currentTimeMillis()

    if (shouldCleanUp) {
        connector.cleanTable("items", true)
        connector.cleanTable("npcs", true)
        connector.cleanTable("skills", true)
        connector.cleanTable("locations", true)
        connector.cleanTable("cities", true)
        connector.cleanTable("clans", true)
        connector.cleanTable("connections", true)
        connector.cleanTable("characters", true)
        connector.cleanTable("link_char_item", true)
        connector.cleanTable("link_npc_item", true)
        connector.cleanTable("link_char_skill", true)
        connector.cleanTable("link_npc_skill", true)
        connector.cleanTable("npc_fights", true)
        connector.cleanTable("player_fight", true)
    }

    println("Generating items")
    connector.insertDataInTable("items", Item.generateItems())
    printResultSet(connector.getResultSetOfSelect("items", limit))
    println("-".repeat(20))

    println("Generating skills")
    connector.insertDataInTable("skills", Skill.generateSkills())
    printResultSet(connector.getResultSetOfSelect("skills", limit))
    println("-".repeat(20))

    println("Generating locations")
    connector.insertDataInTable("locations", Location.generateLocations())
    printResultSet(connector.getResultSetOfSelect("locations", limit))
    println("-".repeat(20))

    println("Generating cities")
    connector.insertDataInTable("cities", City.generateCities())
    printResultSet(connector.getResultSetOfSelect("cities", limit))
    println("-".repeat(20))

    println("Generating clans")
    connector.insertDataInTable("clans", Clan.generateClans())
    printResultSet(connector.getResultSetOfSelect("clans", limit), 20)
    println("-".repeat(20))

    println("Generating npcs")
    connector.insertDataInTable("npcs", NPC.generateNpcs(connector.getListOfIds("locations"), 10))
    printResultSet(connector.getResultSetOfSelect("npcs", limit), 20)
    println("-".repeat(20))

    println("Generating connections")
    connector.insertDataInTable(
        "connections",
        MapConnection.generateConnections(
            connector.getListOfIds("locations")
        )
    )
    printResultSet(connector.getResultSetOfSelect("connections", limit), 20)
    println("-".repeat(20))

    println("Generating characters")
    connector.insertDataInTable(
        "characters", PlayerCharacter.generateCharacters(
            connector.getListOfIds("clans"),
            connector.getListOfIds("npcs"),
            connector.getListOfIds("locations")
        )
    )
    printResultSet(connector.getResultSetOfSelect("characters", limit), 20)
    println("-".repeat(20))

    println("Randomizing foreign keys")
    connector.setFieldToRandomId("locations", "cities", "fk_city", "locations.name != cities.name")
    connector.setFieldToRandomId("cities", "characters", "fk_mayor", "cities.name != characters.name")
    connector.setFieldToRandomId("cities", "clans", "fk_leading_clan", "cities.name != clans.name")
    connector.setFieldToRandomId("characters", "npcs", "fk_worst_enemy", "characters.name != npcs.name")
    connector.setFieldToRandomId("characters", "locations", "fk_location", "characters.name != locations.name")
    connector.setFieldToRandomId("characters", "clans", "fk_clan", "characters.name != clans.name")
    connector.setFieldToRandomId("clans", "characters", "fk_leader", "fk_clan = clans.id")

    println("Generating link tables")
    connector.addLinks("link_char_item", "fk_char", "fk_item", "characters", "items", 1000)
    printResultSet(connector.getResultSetOfSelect("link_char_item", limit))
    connector.addLinks("link_npc_item", "fk_npc", "fk_item", "npcs", "items", 1000)
    printResultSet(connector.getResultSetOfSelect("link_npc_item", limit))
    connector.addLinks("link_char_skill", "fk_char", "fk_skill", "characters", "skills", 200)
    printResultSet(connector.getResultSetOfSelect("link_char_skill", limit))
    connector.addLinks("link_npc_skill", "fk_npc", "fk_skill", "npcs", "skills", 200)
    printResultSet(connector.getResultSetOfSelect("link_npc_skill", limit))
    println("-".repeat(20))

    println("Generating fights with NPCs")
    connector.insertDataInTable(
        "npc_fights", NpcFight.generateNpcFights(
            connector.getListOfIds("npcs"),
            connector.getListOfIds("characters"),
            connector.getListOfIds("locations")
        )
    )
    printResultSet(connector.getResultSetOfSelect("npc_fights", limit, orderBy = "kill_time"), 20)
    println("-".repeat(20))

    println("Generating fights between players")
    connector.insertDataInTable(
        "player_fight", PlayerFight.generatePlayerFights(
            connector.getListOfIds("characters"),
            connector.getListOfIds("locations")
        )
    )
    printResultSet(connector.getResultSetOfSelect("player_fight", limit, orderBy = "fight_time"), 20)
    println("-".repeat(20))

    val timeSeconds : Double = (System.currentTimeMillis() - startTime).toDouble() / 1000

    println("Generation took: $timeSeconds seconds")
    println("Generation ended successfully!")
    println("Congratulations!")

}
