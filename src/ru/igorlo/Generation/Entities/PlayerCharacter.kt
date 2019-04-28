package ru.igorlo.Generation.Entities

import ru.igorlo.Generation.Constants
import ru.igorlo.Utilities
import kotlin.random.Random

data class PlayerCharacter(
    val name: String,
    val char_level: Int,
    val experience: Int,
    val health: Int,
    val money: Int,
    val fk_clan: Int,
    val fk_worst_enemy: Int,
    val fk_location: Int
) : DBEntity {
    override fun getValuesMap(): Map<String, Any> {
        val map = HashMap<String, Any>()
        map["name"] = name
        map["char_level"] = char_level
        map["experience"] = experience
        map["health"] = health
        map["money"] = money
        map["fk_clan"] = fk_clan
        map["fk_worst_enemy"] = fk_worst_enemy
        map["fk_location"] = fk_location
        return map
    }

    companion object {
        fun generateCharacters(
            clanSource: Collection<Int>,
            npcSource: Collection<Int>,
            locationSource: Collection<Int>,
            quantity: Int = Constants.GEN_CHARACTERS_QUANTITY,
            randomizer: Random = Random.Default
        ): Collection<PlayerCharacter> {
            val list = mutableListOf<PlayerCharacter>()
            for (i in 0..quantity) {
                list.add(
                    generateCharacter(
                        clanSource,
                        npcSource,
                        locationSource,
                        randomizer
                    )
                )
            }
            return list
        }

        fun generateCharacter(
            clanSource: Collection<Int>,
            npcSource: Collection<Int>,
            locationSource: Collection<Int>,
            randomizer: Random = Random.Default
        ): PlayerCharacter {
            return PlayerCharacter(
                (Utilities.generateNpcName(true, randomizer) + "_" + Utilities.generateRandomString(
                    10,
                    randomizer
                )).take(15),
                randomizer.nextInt(
                    Constants.GEN_CHARACTERS_MIN_LEVEL,
                    Constants.GEN_CHARACTERS_MAX_LEVEL
                ),
                randomizer.nextInt(
                    Constants.GEN_CHARACTERS_MIN_EXP,
                    Constants.GEN_CHARACTERS_MAX_EXP
                ),
                randomizer.nextInt(
                    Constants.GEN_CHARACTERS_MIN_HP,
                    Constants.GEN_CHARACTERS_MAX_HP
                ),
                randomizer.nextInt(
                    Constants.GEN_CHARACTERS_MIN_MONEY,
                    Constants.GEN_CHARACTERS_MAX_MONEY
                ),
                clanSource.random(randomizer),
                npcSource.random(randomizer),
                locationSource.random(randomizer)
            )
        }
    }
}