package dev.dakoda.alr.character.stats.effects

import dev.dakoda.alr.character.stats.StatsService
import dev.dakoda.alr.combat.CombatService.Effect.Companion.cond
import dev.dakoda.alr.combat.CombatService.Effect.Companion.phys
import dev.dakoda.alr.combat.Combatant

class EffectTicking(
    val tickPhysical: Double,
    val tickConditional: Double,
    val tickEthereal: Double,
    val turns: Int,
    var turnsLeft: Int = turns,
    val isHealing: Boolean = false,
    val isHealingMana: Boolean = false
) : Effect {

    companion object {

        // -- PHYSICAL --
        /**
         * Apply a specified tick of physical damage
         * for a specified amount of turns
         */
        fun bleed(attacker: Combatant, receiver: Combatant, damage: Double, turns: Int) = with(StatsService) {
            applyEffect(
                receiver.stats,
                EffectTicking(damage, 0.0, 0.0, turns)
            )
        }

        /**
         * Apply a specified percent tick of physical damage
         * for a specified amount of turns
         */
        fun bleedPercent(attacker: Combatant, receiver: Combatant, percent: Int, turns: Int) = with(StatsService) {
            bleed(
                attacker,
                receiver,
                (percent / 100) * attacker.phys,
                turns
            )
        }

        // -- CONDITIONAL --
        /**
         * Apply a specified tick of conditional damage
         * for a specified amount of turns
         */
        fun poison(attacker: Combatant, receiver: Combatant, damage: Double, turns: Int) = with(StatsService) {
            applyEffect(
                receiver.stats,
                EffectTicking(0.0, damage, 0.0, turns)
            )
        }

        /**
         * Apply a specified percent tick of conditional damage
         * for a specified amount of turns
         */
        fun poisonPercent(attacker: Combatant, receiver: Combatant, percent: Int, turns: Int) = with(StatsService) {
            poison(
                attacker,
                receiver,
                (percent / 100) * attacker.cond,
                turns
            )
        }

        // -- ETHEREAL --
        /**
         * Apply a specified tick of ethereal health regeneration
         * for a specified amount of turns
         */
        fun rejuvenation(caster: Combatant, receiver: Combatant, tick: Double, turns: Int) {
            StatsService.applyEffect(
                receiver.stats,
                EffectTicking(0.0, 0.0, tick, turns)
            )
        }

        /**
         * Apply a specified percent tick of ethereal health regeneration
         * for a specified amount of turns
         */
        fun rejuvenationPercent(caster: Combatant, receiver: Combatant, percent: Int, turns: Int) {
            rejuvenation(
                caster,
                receiver,
                (percent / 100) * receiver.stats.healthMax,
                turns
            )
        }
    }
}