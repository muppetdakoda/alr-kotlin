package dev.dakoda.alr.character.stats

import dev.dakoda.alr.character.stats.Effect.TickingEffect

class Stats(
    var health: Double,
    var healthMax: Double,
    var mana: Double,
    var manaMax: Double,
    var courageBase: Double,
    var dexterityBase: Double,
    var intelligenceBase: Double,
    var critDamageBase: Double,
    var critChanceBase: Float
) {

    var healthMaxDiff: Double = 0.0
    var manaMaxDiff: Double = 0.0
    var courageDiff: Double = 0.0
    var dexterityDiff: Double = 0.0
    var intelligenceDiff: Double = 0.0
    var critDamageDiff: Double = 0.0
    var critChanceDiff: Double = 0.0

    val ticksThisTurn: MutableList<TickingEffect> = mutableListOf()
    val currentEffects: MutableList<Effect> = mutableListOf()
}