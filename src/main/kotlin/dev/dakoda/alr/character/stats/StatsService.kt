package dev.dakoda.alr.character.stats

import dev.dakoda.alr.character.stats.effects.Effect
import dev.dakoda.alr.character.stats.effects.EffectTicking
import dev.dakoda.alr.combat.Damage
import dev.dakoda.alr.combat.Damage.Type.CONDITIONAL
import dev.dakoda.alr.combat.Damage.Type.ETHEREAL
import dev.dakoda.alr.combat.Damage.Type.PHYSICAL

object StatsService {

    fun applyEffect(stats: Stats, effect: Effect) = stats.activeEffects.add(effect)

    fun removeEffect(stats: Stats, effect: Effect) = stats.activeEffects.remove(effect)

    fun calculateTickingEffects(stats: Stats) = with(stats) {
        val markedForRemoval = mutableListOf<EffectTicking>()
        activeEffects.filterIsInstance<EffectTicking>().forEach {
            if (it.turnsLeft > 0) {
                ticksThisTurn.add(it.apply {
                    turnsLeft -= 1
                })
            } else {
                markedForRemoval.add(it)
            }
        }
        markedForRemoval.forEach { marked -> activeEffects.remove(marked) }
    }

    fun applyHealthChanges(stats: Stats, damage: Damage) {
        with(stats) {
            receiveHealthChanges(damage.physical, PHYSICAL)
            receiveHealthChanges(damage.conditional, CONDITIONAL)
            receiveHealthChanges(damage.ethereal, ETHEREAL)
            roundHealthIntoBoundaries()
        }
    }

    fun applyManaChanges(stats: Stats, damage: Damage) {
        with(stats) {
            receiveManaChanges(damage.physical, PHYSICAL)
            receiveManaChanges(damage.conditional, CONDITIONAL)
            receiveManaChanges(damage.ethereal, ETHEREAL)
            roundManaIntoBoundaries()
        }
    }

    fun calculateOutrightEffects(stats: Stats) = with(stats) {
        statsDiffs.currentEffects.filterIsInstance<Effect.EffectStatus>().forEach {
            healthMaxDiff += it.healthMax
            manaMaxDiff += it.manaMax
            courageDiff += it.courage
            dexterityDiff += it.dexterity
            intelligenceDiff += it.intelligence
            critDamageDiff += it.critDamage
            critChanceDiff += it.critChance
        }
    }

    fun clearEffects(stats: Stats) = with(stats) {
        ticksThisTurn.clear().also { activeEffects.clear() }
    }

    fun clearOutrightEffects(stats: Stats) = with(stats) {
        activeEffects.removeIf { it is Effect.EffectStatus }
    }

    fun clearTickingEffects(stats: Stats) = with(stats) {
        activeEffects.removeIf {
            it is EffectTicking
        }.also { ticksThisTurn.clear() }
    }
}