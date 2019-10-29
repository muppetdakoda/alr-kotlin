package dev.dakoda.alr.domain

import dev.dakoda.alr.domain.character.Stat
import dev.dakoda.alr.domain.item.Accessory
import dev.dakoda.alr.domain.item.Armour
import dev.dakoda.alr.domain.item.Consumable
import dev.dakoda.alr.domain.item.Item
import dev.dakoda.alr.domain.item.Weapon
import dev.dakoda.alr.repository.entity.ItemEntity
import java.util.UUID

class MockedItem {

    companion object {

        fun junk(
            name: String = "Mocked junk item",
            description: String = "Mocked junk item description",
            value: Int = 20,
            generateID: Boolean = true
        ) = Item(
            name = name,
            description = description,
            value = value
        ).apply { if (generateID) id = UUID.randomUUID().toString() }

        fun junkEntity(
            id: String = UUID.randomUUID().toString(),
            name: String = "Mocked junk item",
            description: String = "Mocked junk item description",
            value: Int = 20
        ) = ItemEntity(
            id = id,
            name = name,
            type = "JUNK",
            description = description,
            value = value
        )

        fun weapon(
            name: String = "Mocked weapon",
            damage: Int = 1,
            description: String = "Mocked weapon description",
            value: Int = 20,
            generateID: Boolean = true
        ) = Weapon(
            name = name,
            damage = damage,
            description = description,
            value = value
        ).apply { if (generateID) id = UUID.randomUUID().toString() }

        fun consumable(
            name: String = "Mocked consumable",
            stats: MutableList<Stat> = mutableListOf(),
            description: String = "Mocked consumable description",
            value: Int = 20,
            generateID: Boolean = true
        ) = Consumable(
            name = name,
            stats = stats,
            description = description,
            value = value
        ).apply { if (generateID) id = UUID.randomUUID().toString() }

        fun armour(
            name: String = "Mocked piece of armour",
            protection: Int = 1,
            description: String = "Mocked piece of armour description",
            value: Int = 20,
            generateID: Boolean = true
        ) = Armour(
            name = name,
            protection = protection,
            description = description,
            value = value
        ).apply { if (generateID) id = UUID.randomUUID().toString() }

        fun accessory(
            name: String = "Mocked accessory",
            stats: MutableList<Stat> = mutableListOf(),
            description: String = "Mocked accessory description",
            value: Int = 20,
            generateID: Boolean = true
        ) = Accessory(
            name = name,
            stats = stats,
            description = description,
            value = value
        ).apply { if (generateID) id = UUID.randomUUID().toString() }
    }
}