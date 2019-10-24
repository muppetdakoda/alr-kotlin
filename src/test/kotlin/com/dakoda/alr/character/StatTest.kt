package com.dakoda.alr.character

import dev.dakoda.dassert.dassert
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.valiktor.ConstraintViolationException

class StatTest {

    @Test
    fun `When creating a weapon with a negative monetary value, then throw a Valiktor constraint violation exception`() {
        assertThrows<ConstraintViolationException> {
            Stat(
                type = StatType.COURAGE,
                value = -1f
            )
        }
    }

    @Test
    fun `When creating a weapon, it is instantiated correctly`() {
        val stat: Stat? = Stat(
            type = StatType.COURAGE,
            value = 20f
        )

        dassert {
            with(stat!!) {
                type equals StatType.COURAGE
                value equals 20f
            }
        }
    }
}