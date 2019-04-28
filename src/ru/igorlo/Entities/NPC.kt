package ru.igorlo.Entities

import ru.igorlo.Constants
import ru.igorlo.Utilities
import kotlin.random.Random

data class NPC(val name : String, val experience : Int) : DBEntity {
    override fun getValuesMap(): Map<String, Any> {
        val map = HashMap<String, Any>()
        map["name"] = name
        map["experience"] = experience
        return map
    }

    companion object {
        fun generateNpcs(
            quantity: Int = Constants.GEN_NPCS_QUANTITY_DEFAULT,
            randomizer: Random = Random.Default
        ): Collection<NPC> {
            val list = mutableListOf<NPC>()
            for (i in 0..quantity) {
                list.add(generateNpc(randomizer))
            }
            return list
        }

        private fun generateNpc(randomizer: Random = Random.Default): NPC {
            return NPC(
                Utilities.generateNpcName(true, randomizer).take(15),
                randomizer.nextInt(Constants.GEN_NPCS_MIN_EXP, Constants.GEN_NPCS_MAX_EXP)
            )
        }
    }
}