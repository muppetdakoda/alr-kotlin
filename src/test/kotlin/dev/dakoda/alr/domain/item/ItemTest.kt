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
    fun `Equally instantiated Item objects are equal`() {
        val first = MockItem.generic(generateID = false)
        val second = MockItem.generic(generateID = false)

        dassert {
            first equals second
            first.hashCode() equals second.hashCode()
        }
    }

    @Test
    fun `Unequally instantiated Item objects are not equal`() {
        val first = MockItem.generic(
            name = "Random item",
            description = "1234567890",
            value = 2340,
            generateID = false
        )
        val second = MockItem.weapon(
            name = "Some other item",
            description = "abcdefghij",
            value = 15901,
            generateID = true
        )
        val third = MockItem.consumable(
            name = "Yet another item",
            description = "098654321",
            value = 12345,
            generateID = false
        )
        val fourth = MockItem.armour(
            name = "Wow, another item",
            description = "zyxwvuts",
            value = 54321,
            generateID = true
        )

        dassert {
            first isNotEqualTo second; first isNotEqualTo third; first isNotEqualTo fourth
            second isNotEqualTo third; second isNotEqualTo fourth
            third isNotEqualTo fourth
        }
    }

    @Test
    fun `An Item object can only be equal to another Item object`() {
        val first = MockItem.generic()
        val second = "Item"

        dassert {
            first isNotEqualTo second
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