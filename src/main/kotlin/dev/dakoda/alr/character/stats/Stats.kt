package dev.dakoda.alr.character.stats

import dev.dakoda.alr.character.stats.StatEffect.OutrightEffect
import dev.dakoda.alr.character.stats.StatEffect.TickingEffect
import dev.dakoda.alr.combat.Damages

class Stats(
    var health: Double,
    var healthMax: Double,
    var mana: Double,
    var manaMax: Double,
    var courageBase: Int,
    var dexterityBase: Int,
    var intelligenceBase: Int,
    var critDamageBase: Int,
    var critChanceBase: Float
) {

    var healthMaxDiff: Double = 0.0
    var manaMaxDiff: Double = 0.0
    var courageDiff: Int = 0
    var dexterityDiff: Int = 0
    var intelligenceDiff: Int = 0
    var critDamageDiff: Int = 0
    var critChanceDiff: Float = 0f

    val ticksThisTurn: MutableList<TickingEffect> = mutableListOf()
    val currentEffects: MutableList<StatEffect> = mutableListOf()
}