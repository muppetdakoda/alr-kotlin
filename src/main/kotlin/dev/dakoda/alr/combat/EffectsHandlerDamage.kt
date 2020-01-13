package dev.dakoda.alr.combat

import dev.dakoda.alr.character.stats.Effect.TickingEffect
import dev.dakoda.alr.character.stats.StatsService
import dev.dakoda.alr.combat.CombatService.Effect.Companion.cond
import dev.dakoda.alr.combat.CombatService.Effect.Companion.phys
import kotlin.random.Random

object EffectsHandlerDamage {

    /**
     * Apply a tick of 15% physical damage (or specified percent)
     * for 1 to 3 turns (or specified amount of turns)
     */
    fun bleed(attacker: Combatant, receiver: Combatant, percent: Int = 15, turns: Int = 0) = with(StatsService) {
        val tick = (percent / 100) * attacker.phys
        val turnsCalc = turns.takeIf { it > 0 } ?: Random.nextInt(1, 4)
        applyEffect(receiver.stats, TickingEffect(tick, 0.0, 0.0, turnsCalc))
    }

    /** Apply a tick of 10% conditional damage (or specified percent)
     * for 2 to 5 turns (or specified amount of turns)
     */
    fun poison(attacker: Combatant, receiver: Combatant, percent: Int = 10, turns: Int = 0) = with(StatsService) {
        val tick = (percent / 100) * attacker.cond
        val turnsCalc = turns.takeIf { it > 0 } ?: Random.nextInt(2, 6)
        applyEffect(receiver.stats, TickingEffect(0.0, tick, 0.0, turnsCalc))
    }
}