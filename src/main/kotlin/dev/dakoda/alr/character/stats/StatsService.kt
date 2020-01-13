package dev.dakoda.alr.character.stats

import dev.dakoda.alr.combat.Damages

object StatsService {

    fun applyEffect(stats: Stats, effect: Effect) = stats.currentEffects.add(effect)

    fun removeEffect(stats: Stats, effect: Effect) = stats.currentEffects.remove(effect)

    fun calculateTickingEffects(stats: Stats) {
        with(stats) {
            val markedForRemoval = mutableListOf<Effect.TickingEffect>()
            currentEffects.filterIsInstance<Effect.TickingEffect>().forEach {
                if (it.turnsLeft > 0) {
                    ticksThisTurn.add(it.apply {
                        turnsLeft -= 1
                    })
                } else {
                    markedForRemoval.add(it)
                }
            }
            markedForRemoval.forEach { marked -> currentEffects.remove(marked) }
        }
    }

    fun applyHealthChanges(stats: Stats, damages: Damages) {
        with(stats) {
            health -= damages.physical
            health -= damages.conditional
            health -= damages.ethereal
            if (health < 0) health = 0.0
            if (health > healthMax) health = healthMax
        }
    }

    fun calculateOutrightEffects(stats: Stats) = with(stats) {
        currentEffects.filterIsInstance<Effect.StatusEffect>().forEach {
            healthMaxDiff += it.healthMax
            manaMaxDiff += it.manaMax
            courageDiff += it.courage
            dexterityDiff += it.dexterity
            intelligenceDiff += it.intelligence
            critDamageDiff += it.critDamage
            critChanceDiff += it.critChance
        }
    }

    fun clearEffects(stats: Stats) = with(stats) { ticksThisTurn.clear().also { currentEffects.clear() } }

    fun clearOutrightEffects(stats: Stats) = with(stats) {
        currentEffects.removeIf { it is Effect.StatusEffect }
    }

    fun clearTickingEffects(stats: Stats) = with(stats) {
        currentEffects.removeIf { it is Effect.TickingEffect }.also { ticksThisTurn.clear() }
    }
}