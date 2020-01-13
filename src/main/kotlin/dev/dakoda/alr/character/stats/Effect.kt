package dev.dakoda.alr.character.stats

interface Effect {

    class InstantEffect(
        val health: Double,
        val mana: Double
    ) : Effect

    class StatusEffect(
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

    class TickingEffect(
        val tickPhysical: Double,
        val tickConditional: Double,
        val tickEthereal: Double,
        val turns: Int,
        var turnsLeft: Int = turns,
        val isHealing: Boolean = false,
        val isHealingMana: Boolean = false
    ) : Effect
}