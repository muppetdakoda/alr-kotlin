package dev.dakoda.alr.character.stats

interface StatEffect {

    class OutrightEffect private constructor(
        val healthMax: Double,
        val manaMax: Double,
        val courage: Int,
        val dexterity: Int,
        val intelligence: Int,
        val critDamage: Int,
        val critChance: Float,
        val turns: Int
    ) : StatEffect {
        var turnsLeft = turns

        companion object {
            fun cowardice(amount: Int, turns: Int) = OutrightEffect(0.0, 0.0, amount, 0, 0, 0, 0f, turns)
            fun hesitation(amount: Int, turns: Int) = OutrightEffect(0.0, 0.0, 0, amount, 0, 0, 0f, turns)
            fun ignorance(amount: Int, turns: Int) = OutrightEffect(0.0, 0.0, 0, 0, amount, 0, 0f, turns)
        }
    }

    class TickingEffect private constructor(
        val tickPhysical: Double,
        val tickConditional: Double,
        val tickEthereal: Double,
        val turns: Int,
        val isHealing: Boolean = false
    ) : StatEffect {
        var turnsLeft = turns

        companion object {
            fun bleed(tick: Double, turns: Int) = TickingEffect(tick, 0.0, 0.0, turns)
            fun poison(tick: Double, turns: Int) = TickingEffect(0.0, tick, 0.0, turns)
            fun drain(tick: Double, turns: Int) = TickingEffect(0.0, 0.0, tick, turns)

            fun rejuvenation(tick: Double, turns: Int) = TickingEffect(0.0, 0.0, tick, turns, true)
        }
    }
}

