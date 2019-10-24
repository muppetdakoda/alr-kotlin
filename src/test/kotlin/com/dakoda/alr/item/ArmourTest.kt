package com.dakoda.alr.item

import dev.dakoda.dassert.dassert
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.valiktor.ConstraintViolationException

class ArmourTest {

    @Test
    fun `When creating a piece of armour with a blank name, then throw a Valiktor constraint violation exception`() {
        assertThrows<ConstraintViolationException> {
            Armour(
                name = "",
                protection = 1
            )
        }
    }

    @Test
    fun `When creating a piece of armour with a monetary negative value, then throw a Valiktor constraint violation exception`() {
        assertThrows<ConstraintViolationException> {
            Armour(
                name = "test item",
                protection = 1,
                value = -1
            )
        }
    }

    @Test
    fun `When creating a piece of armour with negative damage, then throw a Valiktor constraint violation exception`() {
        assertThrows<ConstraintViolationException> {
            Armour(
                name = "test item",
                protection = -1
            )
        }
    }

    @Test
    fun `When creating a piece of armour, it is instantiated correctly`() {
        val armour: Armour? = Armour(
            name = "test armour",
            protection = 1,
            description = "a armour",
            value = 20
        )

        dassert {
            with(armour!!) {
                name equals "test armour"
                protection equals 1
                type equals ItemType.ARMOUR
                description equals "a armour"
                value equals 20
            }
        }
    }
}