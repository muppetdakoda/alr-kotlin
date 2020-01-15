package dev.dakoda.alr.character.stats.effects

class EffectStatus(
    val healthMax: Double,
    val manaMax: Double,
    val courage: Double,
    val dexterity: Double,
    val intelligence: Double,
    val critDamage: Double,
    val critChance: Double,
    val turns: Int,
    var turnsLeft: Int = turns
) : Effect