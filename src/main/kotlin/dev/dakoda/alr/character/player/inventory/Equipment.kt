package dev.dakoda.alr.character.player.inventory

import dev.dakoda.alr.character.inventory.item.Armour
import dev.dakoda.alr.character.inventory.item.ArmourSlot
import dev.dakoda.alr.character.inventory.item.ArmourSlot.ARMS
import dev.dakoda.alr.character.inventory.item.ArmourSlot.CHEST
import dev.dakoda.alr.character.inventory.item.ArmourSlot.FEET
import dev.dakoda.alr.character.inventory.item.ArmourSlot.FINGER_1
import dev.dakoda.alr.character.inventory.item.ArmourSlot.FINGER_2
import dev.dakoda.alr.character.inventory.item.ArmourSlot.HEAD
import dev.dakoda.alr.character.inventory.item.ArmourSlot.LEGS
import dev.dakoda.alr.character.inventory.item.ArmourSlot.NECK
import dev.dakoda.alr.character.inventory.item.ArmourSlot.SHOULDERS
import dev.dakoda.alr.character.inventory.item.Energies
import dev.dakoda.alr.character.inventory.item.ItemRarity.BASIC
import dev.dakoda.alr.character.inventory.item.Weapon
import dev.dakoda.alr.character.inventory.item.WeaponSlot
import dev.dakoda.alr.character.inventory.item.WeaponSlot.MAINHAND
import dev.dakoda.alr.character.inventory.item.WeaponSlot.OFFHAND
import dev.dakoda.alr.character.inventory.item.WeaponType.SWORD
import dev.dakoda.alr.character.stats.StatsDiffs
import dev.dakoda.alr.combat.Damage

class Equipment {

    var armours = mutableMapOf<ArmourSlot, Armour>()
    val head get() = armours[HEAD]
    val shoulders get() = armours[SHOULDERS]
    val chest get() = armours[CHEST]
    val arms get() = armours[ARMS]
    val legs get() = armours[LEGS]
    val feet get() = armours[FEET]
    val neck get() = armours[NECK]
    val finger1 get() = armours[FINGER_1]
    val finger2 get() = armours[FINGER_2]

    var weapons = mutableMapOf<WeaponSlot, Weapon>()
    val mainHand get() = weapons[MAINHAND]
    val offHand get() = weapons[OFFHAND]

    val isHoldingDoubleHanded: Boolean get() = mainHand == offHand

    companion object {

        val BLANK_WEAPON = Weapon(
            id = "W0",
            name = "Empty Slot",
            description = "",
            value = 0,
            image = "",
            rarity = BASIC,
            type = SWORD,
            damage = Damage(0.0, 0.0, 0.0),
            energies = Energies(0, 0, 0, 0, 0, 0),
            statsDiffs = StatsDiffs(),
            experience = EquipmentExperience(0, 0.0, 0, 0)
        )

        val BLANK_ARMOUR = Armour(
            id = "A0",
            name = "Empty Slot",
            description = "",
            value = 0,
            image = "",
            rarity = BASIC,
            slot = CHEST,
            damage = Damage(0.0, 0.0, 0.0),
            energies = Energies(0, 0, 0, 0, 0, 0),
            statsDiffs = StatsDiffs(),
            experience = EquipmentExperience(0, 0.0, 0, 0)
        )
    }
}