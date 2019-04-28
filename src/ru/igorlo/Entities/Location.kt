package ru.igorlo.Entities

import ru.igorlo.Constants
import ru.igorlo.Utilities
import kotlin.random.Random

data class Location(val name: String, val x_coord: Int, val y_coord: Int) : DBEntity {
    override fun getValuesMap(): Map<String, Any> {
        val map = HashMap<String, Any>()
        map["name"] = name
        map["x_coord"] = x_coord
        map["y_coord"] = y_coord
        return map
    }

    companion object {
        fun generateLocations(
            quantity: Int = Constants.GEN_LOCATIONS_QUANTITY_DEFAULT,
            randomizer: Random = Random.Default
        ): Collection<Location> {
            val list = mutableListOf<Location>()
            for (i in 0..quantity) {
                list.add(generateLocation(randomizer))
            }
            return list
        }

        private fun generateLocation(randomizer: Random = Random.Default): Location {
            return Location(
                Utilities.generateLocationName(randomizer),
                randomizer.nextInt(Constants.GEN_LOCATIONS_MIN_X, Constants.GEN_LOCATIONS_MAX_X),
                randomizer.nextInt(Constants.GEN_LOCATIONS_MIN_Y, Constants.GEN_LOCATIONS_MAX_Y)
            )
        }
    }
}