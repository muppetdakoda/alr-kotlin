package dev.dakoda.alr.domain.item

import dev.dakoda.alr.fake
import dev.dakoda.dassert.dassert
import org.junit.jupiter.api.Test

class ItemTest {

    @Test
    fun `When creating an item, it is instantiated correctly`() {
        val mockedItem = Item.fake(
            name = "testing item 123",
            type = ItemType.CONSUMABLE,
            description = "some test item",
            value = 12390,
            damage = 4,
            protection = 16,
            courage = 1,
            dexterity = 21,
            wisdom = -4,
            health = 200,
            mana = 400
        )

        with(mockedItem) {
            dassert {
                name equals "testing item 123"
                type equals ItemType.CONSUMABLE
                description equals "some test item"
                value equals 12390
                damage equals 4
                protection equals 16
                courage equals 1
                dexterity equals 21
                wisdom equals -4
                health equals 200
                mana equals 400
            }
        }
    }

    @Test
    fun `Unequally instantiated item objects are not equal`() {
        var first = Item.fake(
            name = "testing item 123",
            type = ItemType.CONSUMABLE,
            description = "some test item",
            value = 12390,
            damage = 4,
            protection = 16,
            courage = 1,
            dexterity = 21,
            wisdom = -4,
            health = 200,
            mana = 400
        )

        var second = Item.fake(
            name = "testing item 12345",
            type = ItemType.WEAPON,
            description = "some test item 2",
            value = 123902,
            damage = 42,
            protection = 162,
            courage = 12,
            dexterity = 212,
            wisdom = -42,
            health = 2002,
            mana = 4002
        )

        dassert {
            first isNotEqualTo second
        }

        first = Item.fake(generateId = false)
        second = Item.fake(generateId = false)
        val third = Item.fake()

        dassert {
            first equals second
            first isNotEqualTo third
            third isNotEqualTo second
        }
    }
}