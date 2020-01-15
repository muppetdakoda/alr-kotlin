package dev.dakoda.alr.combat

class Damage(
    var physical: Double,
    var conditional: Double,
    var ethereal: Double
) {
    companion object {
        val empty get() = Damage(0.0, 0.0, 0.0)

        fun of(physical: Double, conditional: Double, ethereal: Double) = Damage(physical, conditional, ethereal)

        fun physical(value: Double) = Damage(value, 0.0, 0.0)

        fun conditional(value: Double) = Damage(0.0, value, 0.0)

        fun ethereal(value: Double) = Damage(0.0, 0.0, value)
    }

    enum class Type {
        PHYSICAL, CONDITIONAL, ETHEREAL
    }
}