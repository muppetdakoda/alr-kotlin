package dev.dakoda.alr.controller.item.io

import dev.dakoda.alr.domain.item.ItemType

class ItemGetRequestShort(
    val id: String,
    val name: String,
    val type: ItemType,
    val description: String,
    val value: Int
)