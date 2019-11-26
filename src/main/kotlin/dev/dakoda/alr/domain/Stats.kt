package dev.dakoda.alr.domain

import au.com.console.kassava.kotlinEquals
import au.com.console.kassava.kotlinToString
import org.valiktor.functions.isPositiveOrZero
import org.valiktor.validate
import java.util.Objects

class Stats(
    var damage: Float = 0f,
    var protection: Float = 0f,
    var clarity: Float = 0f,
    var dodgeChance: Float = 0f,
    var blockChance: Float = 0f,
    var critChance: Float = 0f,
    var critMultiplier: Float = 0f
) {

    private val props = arrayOf(
        Stats::damage, Stats::protection, Stats::clarity, Stats::dodgeChance, Stats::critChance, Stats::critMultiplier
    )

    init {
        validate(this) {
            validate(Stats::damage).isPositiveOrZero()
            validate(Stats::protection).isPositiveOrZero()
            validate(Stats::clarity).isPositiveOrZero()
            validate(Stats::dodgeChance).isPositiveOrZero()
            validate(Stats::blockChance).isPositiveOrZero()
            validate(Stats::critChance).isPositiveOrZero()
            validate(Stats::critMultiplier).isPositiveOrZero()
        }
    }

    override fun equals(other: Any?) = kotlinEquals(other, props)

    override fun toString() = kotlinToString(props)

    override fun hashCode() = Objects.hash(*props)

    companion object
}