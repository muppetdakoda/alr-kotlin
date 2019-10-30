package dev.dakoda.alr.controller.item

import dev.dakoda.alr.controller.item.io.ItemGetRequest
import dev.dakoda.alr.controller.item.io.ItemGetRequestShort
import dev.dakoda.alr.controller.item.io.ItemPostRequest
import dev.dakoda.alr.domain.item.Item

interface ItemParser {

    companion object {

        fun itemResponse(item: Item): ItemGetRequest {
            with(item) {
                return ItemGetRequest(
                    id = id,
                    name = name,
                    type = type,
                    description = description,
                    value = value,
                    damage = damage,
                    protection = protection,
                    courage = courage,
                    dexterity = dexterity,
                    wisdom = wisdom,
                    health = health,
                    mana = mana
                )
            }
        }

        fun parseItem(request: ItemPostRequest): Item {
            with(request) {
                return Item(
                    name = name,
                    type = type,
                    description = description,
                    value = value,
                    damage = damage,
                    protection = protection,
                    courage = courage,
                    dexterity = dexterity,
                    wisdom = wisdom,
                    health = health,
                    mana = mana
                )
            }
        }

        fun mitigatedCollective(items: List<Item>): List<ItemGetRequestShort> {
            return items.map { item ->
                with(item) {
                    ItemGetRequestShort(
                        id = id,
                        name = name,
                        type = type,
                        description = description,
                        value = value
                    )
                }
            }.toList()
        }

        fun mitigatedCollectiveVerbose(items: List<Item>): List<ItemGetRequest> {
            return items.map { itemResponse(it) }.toList()
        }
    }
}