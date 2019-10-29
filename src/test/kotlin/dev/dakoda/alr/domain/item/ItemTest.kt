package dev.dakoda.alr.domain.item

import dev.dakoda.alr.domain.Mocked
import dev.dakoda.dassert.dassert
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.valiktor.ConstraintViolationException

class ItemTest {

    @Test
    fun `When creating an item with a blank name, then throw a Valiktor constraint violation exception`() {
        assertThrows<ConstraintViolationException> {
            Mocked.junk(
                name = ""
            )
        }
    }

    @Test
    fun `When creating an item with a negative monetary value, then throw a Valiktor constraint violation exception`() {
        assertThrows<ConstraintViolationException> {
            Mocked.junk(
                name = "test item",
                value = -1
            )
        }
    }

    @Test
    fun `When creating an item, it is instantiated correctly`() {
        val item: Item? = Mocked.junk(
            name = "test item",
            description = "an item",
            value = 20
        )

        dassert {
            with(item!!) {
                name equals "test item"
                type equals ItemType.JUNK
                description equals "an item"
                value equals 20
            }
        }
    }
}