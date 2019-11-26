package dev.dakoda.alr.domain

import au.com.console.kassava.kotlinEquals
import au.com.console.kassava.kotlinToString
import org.valiktor.functions.isPositiveOrZero
import org.valiktor.validate
import java.util.Objects

class Attributes(
    var courage: Int = 0,
    var dexterity: Int = 0,
    var wisdom: Int = 0
) {

    private val props = arrayOf(
        Attributes::courage, Attributes::dexterity, Attributes::wisdom
    )

    init {
        validate(this) {
            validate(Attributes::courage).isPositiveOrZero()
            validate(Attributes::dexterity).isPositiveOrZero()
            validate(Attributes::wisdom).isPositiveOrZero()
        }
    }

    override fun equals(other: Any?) = kotlinEquals(other, props)

    override fun toString() = kotlinToString(props)

    override fun hashCode() = Objects.hash(*props)

    companion object
}