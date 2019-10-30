package dev.dakoda.alr

import dev.dakoda.alr.controller.item.io.ItemPostRequest
import dev.dakoda.alr.domain.item.Item
import dev.dakoda.alr.domain.item.ItemType
import dev.dakoda.alr.repository.entity.ItemEntity
import java.util.UUID

@Suppress("unused")
fun List<Item>.mocked(count: Int = 3): List<Item> = with(1..count) {
    map { i -> Item.mocked(name = "$i") }
}

fun Item.Companion.mocked(
    name: String = "Mocked item",
    type: ItemType = ItemType.JUNK,
    description: String = "",
    value: Int = 0,
    damage: Int = 0,
    protection: Int = 0,
    courage: Int = 0,
    dexterity: Int = 0,
    wisdom: Int = 0,
    health: Int = 0,
    mana: Int = 0,
    generateId: Boolean = true
) = Item(name, type, description, value, damage, protection, courage, dexterity, wisdom, health, mana).apply {
    if (generateId) id = UUID.randomUUID().toString()
}

fun ItemEntity.Companion.mocked(
    id: String = UUID.randomUUID().toString(),
    name: String = "Mocked item entity",
    type: ItemType = ItemType.JUNK,
    description: String = "",
    value: Int = 0,
    damage: Int = 0,
    protection: Int = 0,
    courage: Int = 0,
    dexterity: Int = 0,
    wisdom: Int = 0,
    health: Int = 0,
    mana: Int = 0
) = ItemEntity(id, name, type.name, description, value, damage, protection, courage, dexterity, wisdom, health, mana)

fun Item.convert() = ItemEntity(
    id, name, type.name, description, value,
    damage, protection,
    courage, dexterity, wisdom,
    health, mana
)

fun ItemPostRequest.Companion.mocked(
    name: String = "Some item",
    type: ItemType = ItemType.JUNK,
    description: String = "",
    value: Int = 0,
    damage: Int = 0,
    protection: Int = 0,
    courage: Int = 0,
    dexterity: Int = 0,
    wisdom: Int = 0,
    health: Int = 0,
    mana: Int = 0
) = ItemPostRequest(name, type, description, value, damage, protection, courage, dexterity, wisdom, health, mana)