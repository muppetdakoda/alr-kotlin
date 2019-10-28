package dev.dakoda.alr.domain.item

import org.valiktor.functions.isNotBlank
import org.valiktor.functions.isPositiveOrZero
import org.valiktor.validate

class Weapon(
    name: String,
    val damage: Int,
    description: String = "",
    value: Int = 0
) : Item(
    name = name,
    type = ItemType.WEAPON,
    description = description,
    value = value
) {

    init {
        validate(this) {
            validate(Weapon::name).isNotBlank()
            validate(Weapon::damage).isPositiveOrZero()
            validate(Weapon::value).isPositiveOrZero()
        }
    }
}