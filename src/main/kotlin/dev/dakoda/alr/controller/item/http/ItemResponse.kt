package dev.dakoda.alr.controller.item.http

import dev.dakoda.alr.domain.item.Item
import dev.dakoda.alr.domain.item.ItemType

class ItemResponse(
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
) {

    constructor(item: Item): this(
        id = item.id,
        name = item.name,
        type = item.type,
        description = item.description,
        value = item.value,
        damage = item.damage,
        protection = item.protection,
        courage = item.courage,
        dexterity = item.dexterity,
        wisdom = item.wisdom,
        health = item.health,
        mana = item.mana
    )
}