package dev.dakoda.alr.domain.item

import dev.dakoda.alr.domain.MockCharacter
import dev.dakoda.alr.domain.MockedItem
import dev.dakoda.dassert.dassert
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.valiktor.ConstraintViolationException

class ConsumableTest {

    @Test
    fun `When creating a consumable with a blank name, then throw a Valiktor constraint violation exception`() {
        assertThrows<ConstraintViolationException> {
            MockedItem.consumable(name = "")
        }
    }

    @Test
    fun `When creating a consumable with a negative monetary value, then throw a Valiktor constraint violation exception`() {
        assertThrows<ConstraintViolationException> {
            MockedItem.consumable(
                name = "test item",
                value = -1
            )
        }
    }

    @Test
    fun `When creating a consumable, it is instantiated correctly`() {
        val consumable: Consumable? = MockedItem.consumable(
            name = "test consumable",
            stats = MockCharacter.stats,
            description = "a consumable",
            value = 20
        )

        dassert {
            with(consumable!!) {
                name equals "test consumable"
                type equals ItemType.CONSUMABLE
                with(stats) {
                    MockCharacter.stats.forEach { stat ->
                        this contains stat
                    }
                }
                description equals "a consumable"
                value equals 20
            }
        }
    }
}