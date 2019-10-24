package com.dakoda.alr.item

import dev.dakoda.dassert.dassert
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.valiktor.ConstraintViolationException

class ConsumableTest {

    @Test
    fun `When creating a consumable with a blank name, then throw a Valiktor constraint violation exception`() {
        assertThrows<ConstraintViolationException> {
            Consumable(name = "")
        }
    }

    @Test
    fun `When creating a consumable with a negative monetary value, then throw a Valiktor constraint violation exception`() {
        assertThrows<ConstraintViolationException> {
            Consumable(
                name = "test item",
                value = -1
            )
        }
    }

    @Test
    fun `When creating a consumable, it is instantiated correctly`() {
        val consumable: Consumable? = Consumable(
            name = "test consumable",
            description = "a consumable",
            value = 20
        )

        dassert {
            with(consumable!!) {
                name equals "test consumable"
                type equals ItemType.CONSUMABLE
                description equals "a consumable"
                value equals 20
            }
        }
    }
}