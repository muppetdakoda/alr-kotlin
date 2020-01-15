package dev.dakoda.alr.combat

import dev.dakoda.alr.character.stats.effects.Effect
import dev.dakoda.alr.character.stats.StatsService
import dev.dakoda.alr.character.stats.StatsService.applyEffect
import dev.dakoda.alr.character.stats.effects.EffectTicking

object EffectsHandlerSupport {

    // Apply a source of mana restoration to a target
    fun healingMana(caster: Combatant, receiver: Combatant, amount: Double) {
        StatsService.applyEffect(receiver.stats,
            EffectTicking(0.0, 0.0, tick, turns)
        )
    }

    // Apply a source of percentage-based mana restoration to a target
    fun healingManaPercent(caster: Combatant, receiver: Combatant, percent: Double) {
        val restoration = (percent / 100) * receiver.stats.manaMax
        applyEffect(receiver.stats, Effect.EffectStatus(0.0, 0.0, turns))
    }


}