package com.dakoda.alr.item

import org.valiktor.functions.isNotBlank
import org.valiktor.functions.isPositiveOrZero
import org.valiktor.validate

class Consumable(
    name: String,
    description: String = "",
    value: Int = 0
): Item(
    name = name,
    type = ItemType.CONSUMABLE,
    description = description,
    value = value
) {

    init {
        validate(this) {
            validate(Consumable::name).isNotBlank()
            validate(Consumable::value).isPositiveOrZero()
        }
    }
}