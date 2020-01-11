package dev.dakoda.alr.combat

class Damages(
    var physical: Double,
    var conditional: Double,
    var ethereal: Double
) {
    companion object {
        val empty get() = Damages(0.0, 0.0, 0.0)

        fun of(physical: Double, conditional: Double, ethereal: Double) = Damages(physical, conditional, ethereal)

        fun physical(value: Double) = Damages(value, 0.0, 0.0)

        fun conditional(value: Double) = Damages(0.0, value, 0.0)

        fun ethereal(value: Double) = Damages(0.0, 0.0, value)
    }
}