package dev.dakoda.alr.controller.item.http

import dev.dakoda.alr.domain.item.ItemType

class ItemResponseShort(
    val id: String,
    val name: String,
    val type: ItemType,
    val description: String,
    val value: Int
)