package ru.igorlo.Entities

import ru.igorlo.Constants
import ru.igorlo.Utilities
import kotlin.random.Random

data class Skill(val name: String, val mult: Double) : DBEntity {

    override fun getValuesMap(): Map<String, Any> {
        val map = HashMap<String, Any>()
        map["name"] = name
        map["mult"] = mult
        return map
    }

    companion object {
        fun generateSkills(
            quantity: Int = Constants.GEN_SKILLS_QUANTITY_DEFAULT,
            randomizer: Random = Random.Default
        ): Collection<Skill> {
            val list = mutableListOf<Skill>()
            for (i in 0..quantity) {
                list.add(generateSkill(randomizer))
            }
            return list
        }

        private fun generateSkill(randomizer: Random = Random.Default): Skill {
            return Skill(
                Utilities.generateSkillName(),
                Constants.GEN_SKILLS_MIN_MULT + randomizer.nextDouble(Constants.GEN_SKILLS_MAX_MULT)
            )
        }
    }

}