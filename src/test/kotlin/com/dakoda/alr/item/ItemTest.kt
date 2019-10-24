package com.dakoda.alr.item

import dev.dakoda.dassert.dassert
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.valiktor.ConstraintViolationException

class ItemTest {

    @Test
    fun `When creating an item with a blank name, then throw a Valiktor constraint violation exception`() {
        assertThrows<ConstraintViolationException> {
            Item(
                name = "",
                type = ItemType.GENERIC
            )
        }
    }

    @Test
    fun `When creating an item with a negative monetary value, then throw a Valiktor constraint violation exception`() {
        assertThrows<ConstraintViolationException> {
            Item(
                name = "test item",
                type = ItemType.GENERIC,
                value = -1
            )
        }
    }

    @Test
    fun `When creating an item, it is instantiated correctly`() {
        val item: Item? = Item(
            name = "test item",
            type = ItemType.GENERIC,
            description = "a item",
            value = 20
        )

        dassert {
            with(item!!) {
                name equals "test item"
                type equals ItemType.GENERIC
                description equals "a item"
                value equals 20
            }
        }
    }
}