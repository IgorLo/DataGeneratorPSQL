package ru.igorlo.Entities

import ru.igorlo.Constants
import ru.igorlo.Utilities
import kotlin.random.Random

data class Clan(val name: String, val rating: Int) : DBEntity {
    override fun getValuesMap(): Map<String, Any> {
        val map = HashMap<String, Any>()
        map["name"] = name
        map["rating"] = rating
        return map
    }

    companion object {
        fun generateClans(
            quantity: Int = Constants.GEN_CLANS_QUANTITY_DEFAULT,
            randomizer: Random = Random.Default
        ): Collection<Clan> {
            val list = mutableListOf<Clan>()
            for (i in 0..quantity) {
                list.add(generateClan(randomizer))
            }
            return list
        }

        private fun generateClan(randomizer: Random = Random.Default): Clan {
            return Clan(
                Utilities.generateClanName(randomizer),
                Constants.GEN_CLANS_MIN_RATING + randomizer.nextInt(Constants.GEN_CLANS_MAX_RATING)
            )
        }
    }
}