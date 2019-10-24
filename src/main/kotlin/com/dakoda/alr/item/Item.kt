package com.dakoda.alr.item

import org.valiktor.functions.isNotBlank
import org.valiktor.functions.isPositiveOrZero
import org.valiktor.validate

data class Item(
    val name: String,
    val type: ItemType,
    val description: String = "",
    val value: Int = 0
) {

    init {
        validate(this) {
            validate(Item::name).isNotBlank()
            validate(Item::value).isPositiveOrZero()
        }
    }
}
