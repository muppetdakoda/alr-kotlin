package com.dakoda.alr.item

import org.valiktor.functions.isNotBlank
import org.valiktor.validate

data class Item(
    val name: String,
    val type: ItemType
) {
    init {
        validate(this) {
            validate(Item::name).isNotBlank()
        }
    }
}
