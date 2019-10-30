package dev.dakoda.alr.controller.item.io

import dev.dakoda.alr.domain.item.ItemType

class ItemGetRequest(
    val id: String,
    val name: String,
    val type: ItemType,
    val description: String,
    val value: Int,
    val damage: Int,
    val protection: Int,
    val courage: Int,
    val dexterity: Int,
    val wisdom: Int,
    val health: Int,
    val mana: Int
)