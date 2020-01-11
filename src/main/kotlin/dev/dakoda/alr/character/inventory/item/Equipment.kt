package dev.dakoda.alr.character.inventory.item

import dev.dakoda.alr.character.inventory.item.ItemRarity.BASIC
import dev.dakoda.alr.character.inventory.item.WeaponType.SWORD
import dev.dakoda.alr.character.stats.StatBonus
import dev.dakoda.alr.combat.Damages

class Equipment {

    companion object {
        val BLANK_WEAPON = Weapon(
            id = "W0",
            name = "Empty Slot",
            description = "",
            value = 0,
            image = "",
            rarity = BASIC,
            type = SWORD,
            damages = Damages(0.0, 0.0, 0.0),
            energies = Energies(0, 0, 0, 0, 0, 0),
            statBonus = StatBonus(0, 0, 0, 0, 0f),
            experience = EquipmentExperience(0, 0.0, 0, 0),
            effects = listOf()
        )
    }

    var mainHand = BLANK_WEAPON
    var offHand = BLANK_WEAPON

    val isHoldingDoubleHanded: Boolean get() = mainHand == offHand
}