package com.dakoda.alr.item

import org.valiktor.functions.isNotBlank
import org.valiktor.functions.isPositiveOrZero
import org.valiktor.validate

class Armour(
    name: String,
    val protection: Int,
    description: String = "",
    value: Int = 0
): Item(
    name = name,
    type = ItemType.ARMOUR,
    description = description,
    value = value
) {

    init {
        validate(this) {
            validate(Armour::name).isNotBlank()
            validate(Armour::protection).isPositiveOrZero()
            validate(Armour::value).isPositiveOrZero()
        }
    }
}