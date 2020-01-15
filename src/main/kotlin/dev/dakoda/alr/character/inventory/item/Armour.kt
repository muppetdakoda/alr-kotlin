package dev.dakoda.alr.character.inventory.item

import dev.dakoda.alr.character.player.inventory.EquipmentExperience
import dev.dakoda.alr.character.stats.StatsDiffs
import dev.dakoda.alr.combat.Damage

class Armour(
    val id: String,
    var name: String,
    var description: String = "",
    val value: Long = 0,
    val image: String = "",
    val rarity: ItemRarity = ItemRarity.BASIC,
    val slot: ArmourSlot,
    val damage: Damage,
    val energies: Energies,
    val statsDiffs: StatsDiffs,
    val experience: EquipmentExperience
)