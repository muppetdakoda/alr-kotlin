package dev.dakoda.alr

import dev.dakoda.alr.controller.item.ItemUtils
import dev.dakoda.alr.domain.Attributes
import dev.dakoda.alr.domain.Stats
import dev.dakoda.alr.domain.Vitals
import dev.dakoda.alr.domain.item.Item
import dev.dakoda.alr.domain.item.ItemType
import dev.dakoda.alr.repository.entity.item.ItemEntity

@Suppress("unused")
fun List<Item>.fake(count: Int = 3): List<Item> = with(1..count) {
    map { i -> Item.fake(name = "$i") }
}

fun Item.Companion.fake(
    id: String = ItemUtils.generateID(),
    name: String = "Mocked item",
    type: ItemType = ItemUtils.randomType(),
    description: String = "",
    value: Int = 0,
    attributes: Attributes = Attributes.fake(),
    stats: Stats = Stats.fake(),
    vitals: Vitals = Vitals.fake()
) = Item(id, name, type, description, value, attributes, stats, vitals)

fun Stats.Companion.fake(
    damage: Float = 0f,
    protection: Float = 0f,
    clarity: Float = 0f,
    dodgeChance: Float = 0f,
    blockChance: Float = 0f,
    critChance: Float = 0f,
    critMultiplier: Float = 0f
) = Stats(damage, protection, clarity, dodgeChance, blockChance, critChance, critMultiplier)

fun Vitals.Companion.fake(
    currentHealth: Int = 0,
    health: Int = 0,
    currentMana: Int = 0,
    mana: Int = 0
) = Vitals(currentHealth, health, currentMana, mana)

fun Attributes.Companion.fake(
    courage: Int = 0,
    dexterity: Int = 0,
    wisdom: Int = 0
) = Attributes(courage, dexterity, wisdom)

fun ItemEntity.Companion.fake(
    id: String = ItemUtils.generateID(),
    name: String = "Mocked item entity",
    type: ItemType = ItemUtils.randomType(),
    description: String = "",
    value: Int = 0,
    damage: Int = 0, protection: Int = 0,
    courage: Int = 0, dexterity: Int = 0, wisdom: Int = 0,
    health: Int = 0, mana: Int = 0
) = ItemEntity(id, name, type, description, value, damage, protection, courage, dexterity, wisdom, health, mana)