package dev.dakoda.alr.combat

import dev.dakoda.alr.combat.Spell.SpellProperty.*

class Spell private constructor(
    val name: String,
    val manaCost: Double,
    val props: Map<SpellProperty, Double>
) {
    enum class SpellProperty {
        DAMAGE, DAMAGE_PERCENTAGE, HEALING, HEALING_PERCENTAGE,
        MANA_DAMAGE, MANA_DAMAGE_PERCENTAGE, MANA_HEALING, MANA_HEALING_PERCENTAGE,
        BLEED_PERCENTAGE, POISON_PERCENTAGE, DRAIN_PERCENTAGE,
        COURAGE_INCREASE, COURAGE_INCREASE_PERCENTAGE, COURAGE_REDUCTION, COURAGE_REDUCTION_PERCENTAGE,
        DEXTERITY_INCREASE, DEXTERITY_INCREASE_PERCENTAGE, DEXTERITY_REDUCTION, DEXTERITY_REDUCTION_PERCENTAGE,
        INTELLIGENCE_INCREASE, INTELLIGENCE_INCREASE_PERCENTAGE, INTELLIGENCE_REDUCTION, INTELLIGENCE_REDUCTION_PERCENTAGE,
        CRIT_CHANCE_INCREASE, CRIT_CHANCE_REDUCTION,
        CRIT_DAMAGE_INCREASE, CRIT_DAMAGE_REDUCTION,
        TURNS
    }

    companion object {

        val REJUVENATION = Spell(name = "Rejuvenation", manaCost = 35.0, props = mapOf(
            HEALING_PERCENTAGE to 15.0,
            TURNS to 3.0
        ))
        val HOLY_TOUCH = Spell(name = "Holy Touch", manaCost = 50.0, props = mapOf(
            HEALING_PERCENTAGE to 40.0
        ))

        val TAUNT = Spell(name = "Taunt", manaCost = 25.0, props = mapOf(
            COURAGE_REDUCTION_PERCENTAGE to 8.0
        ))
        val WARRIOR_SHOUT = Spell(name = "Warrior Shout", manaCost = 65.0, props = mapOf(
            COURAGE_REDUCTION_PERCENTAGE to 20.0
        ))

        val INHIBIT = Spell(name = "Inhibit", manaCost = 40.0, props = mapOf(
            DEXTERITY_REDUCTION_PERCENTAGE to 12.0
        ))
        val HINDERING_STRIKE = Spell(name = "Hindering Strike", manaCost = 65.0, props = mapOf(
            DEXTERITY_REDUCTION_PERCENTAGE to 25.0
        ))

        val BOAST = Spell(name = "Boast", manaCost = 40.0, props = mapOf(
            INTELLIGENCE_REDUCTION_PERCENTAGE to 15.0
        ))
        val BRAIN_BURN = Spell(name = "Brain Burn", manaCost = 90.0, props = mapOf(
            INTELLIGENCE_REDUCTION_PERCENTAGE to 28.0
        ))
    }
}