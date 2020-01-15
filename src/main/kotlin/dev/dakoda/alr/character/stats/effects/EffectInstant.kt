package dev.dakoda.alr.character.stats.effects

import dev.dakoda.alr.combat.Combatant

class EffectInstant(
    val health: Double,
    val mana: Double
) : Effect {

    companion object {

        /**
         * Apply a source of healing to a target
         */
        fun healing(caster: Combatant, receiver: Combatant, amount: Double) {

        }

        /**
         * Apply a source of percentage-based healing to a target
         */
        fun healingPercent(caster: Combatant, receiver: Combatant, percent: Double) {
            healing(caster, receiver, (percent / 100) * receiver.stats.healthMax)
        }
    }
}
