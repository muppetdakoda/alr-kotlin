package com.dakoda.alr.domain.item

import org.valiktor.functions.isNotBlank
import org.valiktor.functions.isPositiveOrZero
import org.valiktor.validate

open class Item(
    val name: String,
    val type: ItemType = ItemType.GENERIC,
    val description: String = "",
    val value: Int = 0
) {

    init {
        @Suppress("LeakingThis") validate(this) {
            validate(Item::name).isNotBlank()
            validate(Item::value).isPositiveOrZero()
        }
    }
}