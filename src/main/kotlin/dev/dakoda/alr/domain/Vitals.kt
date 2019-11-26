package dev.dakoda.alr.domain

import au.com.console.kassava.kotlinEquals
import au.com.console.kassava.kotlinToString
import org.valiktor.functions.isPositive
import org.valiktor.functions.isPositiveOrZero
import org.valiktor.validate
import java.util.Objects

class Vitals(
    var currentHealth: Int = 0,
    var health: Int,
    var currentMana: Int = 0,
    var mana: Int
) {

    private val props = arrayOf(
        Vitals::currentHealth, Vitals::health, Vitals::currentMana, Vitals::mana
    )

    init {
        validate(this) {
            validate(Vitals::health).isPositive()
            validate(Vitals::mana).isPositive()
            validate(Vitals::currentHealth).isPositiveOrZero()
            validate(Vitals::currentMana).isPositiveOrZero()
        }
    }

    override fun equals(other: Any?) = kotlinEquals(other, props)

    override fun toString() = kotlinToString(props)

    override fun hashCode() = Objects.hash(*props)

    companion object
}