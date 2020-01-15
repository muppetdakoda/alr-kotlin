package dev.dakoda.alr.character.stats

import dev.dakoda.alr.character.player.Player
import dev.dakoda.alr.character.stats.Stats.Type.BLOCK_CHANCE
import dev.dakoda.alr.character.stats.Stats.Type.CLARITY_CHANCE
import dev.dakoda.alr.character.stats.Stats.Type.COURAGE
import dev.dakoda.alr.character.stats.Stats.Type.CRITICAL_CHANCE
import dev.dakoda.alr.character.stats.Stats.Type.CRITICAL_DAMAGE
import dev.dakoda.alr.character.stats.Stats.Type.DEXTERITY
import dev.dakoda.alr.character.stats.Stats.Type.DODGE_CHANCE
import dev.dakoda.alr.character.stats.Stats.Type.HEALTH
import dev.dakoda.alr.character.stats.Stats.Type.HEALTH_MAX
import dev.dakoda.alr.character.stats.Stats.Type.INTELLIGENCE
import dev.dakoda.alr.character.stats.Stats.Type.MANA
import dev.dakoda.alr.character.stats.Stats.Type.MANA_MAX
import dev.dakoda.alr.character.stats.effects.Effect
import dev.dakoda.alr.character.stats.effects.EffectTicking
import dev.dakoda.alr.combat.Damage
import dev.dakoda.alr.combat.Damage.Type.CONDITIONAL
import dev.dakoda.alr.combat.Damage.Type.ETHEREAL
import dev.dakoda.alr.combat.Damage.Type.PHYSICAL

class Stats(
    ownerPlayer: Player
) {
    val player: Player = ownerPlayer

    var statsBase = mutableMapOf(
        HEALTH to 0.0, MANA to 0.0,
        HEALTH_MAX to 0.0, MANA_MAX to 0.0,
        COURAGE to 0.0, DEXTERITY to 0.0, INTELLIGENCE to 0.0,
        CRITICAL_DAMAGE to 0.0, CRITICAL_CHANCE to 0.0, BLOCK_CHANCE to 0.0, DODGE_CHANCE to 0.0, CLARITY_CHANCE to 0.0
    )

    var statsDiffs = mutableMapOf(
        HEALTH to 0.0, MANA to 0.0,
        HEALTH_MAX to 0.0, MANA_MAX to 0.0,
        COURAGE to 0.0, DEXTERITY to 0.0, INTELLIGENCE to 0.0,
        CRITICAL_DAMAGE to 0.0, CRITICAL_CHANCE to 0.0, BLOCK_CHANCE to 0.0, DODGE_CHANCE to 0.0, CLARITY_CHANCE to 0.0
    )

    val activeEffects: MutableList<Effect> = mutableListOf()

    enum class Type {
        HEALTH, MANA,
        HEALTH_MAX, MANA_MAX,
        COURAGE, DEXTERITY, INTELLIGENCE,
        CRITICAL_DAMAGE, CRITICAL_CHANCE, BLOCK_CHANCE, DODGE_CHANCE, CLARITY_CHANCE
    }

    fun statsBase(type: Type): Double = statsBase[type]?.let { it } ?: 0.0
    fun statsBaseSet(type: Type, value: Double) = statsBase[type]?.let { statsBase[type] = value }
    fun statsBaseDecrease(type: Type, value: Double) = statsBase[type]?.let { statsBase[type] = statsDiffs(type) - value }
    fun statsBaseIncrease(type: Type, value: Double) = statsBase[type]?.let { statsBase[type] = statsDiffs(type) + value }

    fun statsDiffs(type: Type): Double = statsDiffs[type]?.let { it } ?: 0.0
    fun statsDiffsSet(type: Type, value: Double) = statsDiffs[type]?.let { statsDiffs[type] = value }
    fun statsDiffsDecrease(type: Type, value: Double) = statsDiffs[type]?.let { statsDiffs[type] = statsDiffs(type) - value }
    fun statsDiffsIncrease(type: Type, value: Double) = statsDiffs[type]?.let { statsDiffs[type] = statsDiffs(type) + value }

    fun roundHealthIntoBoundaries() {
        if (statsDiffs(HEALTH) < 0) statsDiffsSet(HEALTH, 0.0)
        if (statsDiffs(HEALTH) > statsDiffs(HEALTH_MAX)) statsDiffsSet(HEALTH, statsDiffs(HEALTH_MAX))
    }

    fun roundManaIntoBoundaries() {
        if (statsDiffs(MANA) < 0) statsDiffsSet(MANA, 0.0)
        if (statsDiffs(MANA) > statsDiffs(MANA_MAX)) statsDiffsSet(MANA, statsDiffs(MANA_MAX))
    }

    fun receiveHealthChanges(value: Double, valueType: Damage.Type) {
        // TODO
        statsDiffsIncrease(HEALTH, value) // temporary
        when(valueType) {
            PHYSICAL -> {}
            CONDITIONAL -> {}
            ETHEREAL -> {}
        }
    }

    fun receiveManaChanges(value: Double, valueType: Damage.Type) {
        // TODO
        statsDiffsIncrease(MANA, value) // temporary
        when(valueType) {
            PHYSICAL -> {}
            CONDITIONAL -> {}
            ETHEREAL -> {}
        }
    }
}