package com.dakoda.alr.item

import dev.dakoda.dassert.dassert
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.valiktor.ConstraintViolationException

class AccessoryTest {

    @Test
    fun `When creating an accessory with a blank name, then throw a Valiktor constraint violation exception`() {
        assertThrows<ConstraintViolationException> {
            Accessory(name = "")
        }
    }

    @Test
    fun `When creating an accessory with a negative monetary value, then throw a Valiktor constraint violation exception`() {
        assertThrows<ConstraintViolationException> {
            Accessory(
                name = "test item",
                value = -1
            )
        }
    }

    @Test
    fun `When creating an accessory, it is instantiated correctly`() {
        val accessory: Accessory? = Accessory(
            name = "test accessory",
            description = "an accessory",
            value = 20
        )

        dassert {
            with(accessory!!) {
                name equals "test accessory"
                type equals ItemType.ACCESSORY
                description equals "an accessory"
                value equals 20
            }
        }
    }
}