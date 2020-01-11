package dev.dakoda.alr.character.inventory.item

import dev.dakoda.alr.character.stats.StatBonus
import dev.dakoda.alr.combat.CombatService
import dev.dakoda.alr.combat.Damages

class Weapon(
    val id: String,
    var name: String,
    var description: String = "",
    val value: Long = 0,
    val image: String = "",
    val rarity: ItemRarity = ItemRarity.BASIC,
    val type: WeaponType,
    val damages: Damages,
    val energies: Energies,
    val statBonus: StatBonus,
    val experience: EquipmentExperience,
    val effects: List<CombatService.Effect>
) {

    fun isDoubleHanded() = type.isDoubleHanded
}