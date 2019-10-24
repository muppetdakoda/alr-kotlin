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
                type = ItemType.WEAPON
            )
        }
    }

    @Test
    fun `When creating an item with a negative value, then throw a Valiktor constraint violation exception`() {
        assertThrows<ConstraintViolationException> {
            Item(
                name = "test item",
                type = ItemType.WEAPON,
                value = -1
            )
        }
    }

    @Test
    fun `When creating an item, it is instantiated correctly`() {
        val item: Item? = Item(
            name = "test item",
            type = ItemType.WEAPON,
            description = "a weapon",
            value = 0
        )

        dassert {
            item.isNotNull
            item?.name equals "test item"
            item?.type equals ItemType.WEAPON
            item?.description equals "a weapon"
            item?.value equals 0
        }
    }
}