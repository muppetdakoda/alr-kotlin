package dev.dakoda.alr.combat

import dev.dakoda.alr.character.stats.Effect
import dev.dakoda.alr.character.stats.StatsService

object EffectsHandlerSupport {

    // Apply a source of healing to a target
    fun healing(caster: Combatant, receiver: Combatant, amount: Double) {

    }

    // Apply a source of percentage-based healing to a target
    fun healingPercent(caster: Combatant, receiver: Combatant, amount: Double) {

    }

    // Apply a source of mana restoration to a target
    fun healingMana(caster: Combatant, receiver: Combatant, amount: Double) {
        StatsService.applyEffect(receiver.stats, Effect.TickingEffect(0.0, 0.0, tick, turns))
    }

    // Apply a source of percentage-based mana restoration to a target
    fun healingManaPercent(caster: Combatant, receiver: Combatant, percent: Double) {
        val restoration = (percent / 100) * receiver.stats.manaMax
        StatsService.applyEffect(receiver.stats, Effect.StatusEffect(0.0, 0.0, turns))
    }

    // Apply a tick of regeneration
    // for a certain amount of turns and healing
    fun rejuvenation(caster: Combatant, receiver: Combatant, tick: Double, turns: Int) {
        StatsService.applyEffect(receiver.stats, Effect.TickingEffect(0.0, 0.0, tick, turns))
    }

    // Apply a tick of percentage-based regeneration
    // for a certain amount of turns and healing
    fun rejuvenationPercent(caster: Combatant, receiver: Combatant, percent: Int, turns: Int) {
        val tick = (percent / 100) * receiver.stats.healthMax
        StatsService.applyEffect(receiver.stats, Effect.TickingEffect(0.0, 0.0, tick, turns))
    }
}