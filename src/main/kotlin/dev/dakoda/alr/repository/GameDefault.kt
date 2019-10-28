package dev.dakoda.alr.repository

import dev.dakoda.alr.domain.item.Item
import dev.dakoda.alr.domain.item.ItemType.WEAPON
import dev.dakoda.alr.repository.entity.ItemEntity

class GameDefault {

    companion object {

        val itemEntity = ItemEntity(
            ID = "607baeca-bcda-4628-97e7-9beea73c8ca1",
            name = "Default Sword",
            type = "WEAPON",
            description = "A developer sword item meant for testing; it does no damage.",
            value = "0"
        )

        val item = Item(
            name = "Default Sword",
            type = WEAPON,
            description = "A developer sword item meant for testing; it does no damage.",
            value = "0"
        ).apply { ID = "607baeca-bcda-4628-97e7-9beea73c8ca1" }
    }
}