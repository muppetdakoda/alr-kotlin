package dev.dakoda.alr.controller.item

import dev.dakoda.alr.controller.item.http.ItemResponse
import dev.dakoda.alr.controller.item.http.ItemResponseShort
import dev.dakoda.alr.domain.item.Item

interface HTTPParseItem {

    companion object {

        fun domain(item: Item): ItemResponse {
            with(item) {
                return ItemResponse(
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

        fun domainList(items: List<Item>): List<ItemResponseShort> {
            return items.map { item ->
                with(item) {
                    ItemResponseShort(
                        id = id,
                        name = name,
                        type = type,
                        description = description,
                        value = value
                    )
                }
            }.toList()
        }

        fun domainListVerbose(items: List<Item>): List<ItemResponse> {
            return items.map { domain(it) }.toList()
        }
    }
}