package ru.igorlo.Entities

import ru.igorlo.Constants
import ru.igorlo.Utilities
import kotlin.random.Random

data class City(val name : String) : DBEntity {
    override fun getValuesMap(): Map<String, Any> {
        val map = HashMap<String, Any>()
        map["name"] = name
        return map
    }

    companion object {
        fun generateCities(
            quantity: Int = Constants.GEN_CITIES_QUANTITY_DEFAULT,
            randomizer: Random = Random.Default
        ): Collection<City> {
            val list = mutableListOf<City>()
            for (i in 0..quantity) {
                list.add(generateCity(randomizer))
            }
            return list
        }

        private fun generateCity(randomizer: Random = Random.Default): City {
            return City(
                Utilities.generateCityName(randomizer)
            )
        }
    }
}