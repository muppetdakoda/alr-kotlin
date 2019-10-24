package com.dakoda.alr.item

import dev.dakoda.dassert.dassert
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.valiktor.ConstraintViolationException

class ItemTest {

    @Test
    fun `When creating an item with a blank name, then throw a Valiktor constraint violation exception`() {
        assertThrows<ConstraintViolationException> {
            Item("", ItemType.WEAPON)
        }
    }

    @Test
    fun `When creating an item, it is instantiated correctly`() {
        val item: Item? = Item("test item", ItemType.WEAPON)

        dassert {
            item.isNotNull
            item?.name equals "test item"
            item?.type equals ItemType.WEAPON
        }
    }
}