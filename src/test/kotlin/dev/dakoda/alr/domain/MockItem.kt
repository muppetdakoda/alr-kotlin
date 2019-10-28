package dev.dakoda.alr.domain

import dev.dakoda.alr.domain.character.Stat
import dev.dakoda.alr.domain.item.*
import dev.dakoda.alr.repository.entity.ItemEntity
import java.util.UUID

class MockItem {

    companion object {

        fun generic(
            name: String = "Mock generic item",
            description: String = "Mock generic item description",
            value: Int = 20
        ) = Item(
            name = name,
            description = description,
            value = value
        ).apply { ID = UUID.randomUUID().toString() }

        fun genericEntity(
            id: String = UUID.randomUUID().toString(),
            name: String = "Mock generic item",
            description: String = "Mock generic item description",
            value: Int = 20
        ) = ItemEntity(
            id = id,
            name = name,
            type = "GENERIC",
            description = description,
            value = value
        )

        fun weapon(
            name: String = "Mock weapon",
            damage: Int = 1,
            description: String = "Mock weapon description",
            value: Int = 20
        ) = Weapon(
            name = name,
            damage = damage,
            description = description,
            value = value
        ).apply { ID = UUID.randomUUID().toString() }

        fun consumable(
            name: String = "Mock consumable",
            stats: MutableList<Stat> = mutableListOf(),
            description: String = "Mock consumable description",
            value: Int = 20
        ) = Consumable(
            name = name,
            stats = stats,
            description = description,
            value = value
        ).apply { ID = UUID.randomUUID().toString() }

        fun armour(
            name: String = "Mock piece of armour",
            protection: Int = 1,
            description: String = "Mock piece of armour description",
            value: Int = 20
        ) = Armour(
            name = name,
            protection = protection,
            description = description,
            value = value
        ).apply { ID = UUID.randomUUID().toString() }

        fun accessory(
            name: String = "Mock accessory",
            stats: MutableList<Stat> = mutableListOf(),
            description: String = "Mock accessory description",
            value: Int = 20
        ) = Accessory(
            name = name,
            stats = stats,
            description = description,
            value = value
        ).apply { ID = UUID.randomUUID().toString() }
    }
}