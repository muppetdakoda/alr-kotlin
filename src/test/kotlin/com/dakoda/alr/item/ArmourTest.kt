package com.dakoda.alr.item

import com.dakoda.alr.MockItem
import dev.dakoda.dassert.dassert
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.valiktor.ConstraintViolationException

class ArmourTest {

    @Test
    fun `When creating a piece of armour with a blank name, then throw a Valiktor constraint violation exception`() {
        assertThrows<ConstraintViolationException> {
            MockItem.armour(
                name = "",
                protection = 1
            )
        }
    }

    @Test
    fun `When creating a piece of armour with a monetary negative value, then throw a Valiktor constraint violation exception`() {
        assertThrows<ConstraintViolationException> {
            MockItem.armour(
                name = "test item",
                protection = 1,
                value = -1
            )
        }
    }

    @Test
    fun `When creating a piece of armour with negative protection, then throw a Valiktor constraint violation exception`() {
        assertThrows<ConstraintViolationException> {
            MockItem.armour(
                name = "test item",
                protection = -1
            )
        }
    }

    @Test
    fun `When creating a piece of armour, it is instantiated correctly`() {
        val armour: Armour? = MockItem.armour(
            name = "test piece of armour",
            protection = 1,
            description = "a piece of armour",
            value = 20
        )

        dassert {
            with(armour!!) {
                name equals "test piece of armour"
                protection equals 1
                type equals ItemType.ARMOUR
                description equals "a piece of armour"
                value equals 20
            }
        }
    }
}