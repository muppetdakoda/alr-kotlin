package dev.dakoda.alr.character.inventory.item

import java.util.UUID

/*
- *type:* **Enum (**[WeaponType](https://www.notion.so/WeaponType-b9f87705c9a041cfb5e48998e51e7b23)**)**
- *experience* **(**[Equipment Leveling](https://www.notion.so/Equipment-Leveling-3490f97215f345f3aa2a9fe756b0de15)**)**
    - *level:* **Int** (x ≥ 0)
    - *currentEXP:* **Double** (x ≥ 0.0)
    - *requiredEXP:* **Long** (x ≥ 1)
    - *maxLevel:* **Int** (x ≥ 5)
- *bonuses*
    - *courage:* **Int** (x ≥ 0)
    - *dexterity:* **Int** (x ≥ 0)
    - *intelligence:* **Int** (x ≥ 0)
- *effects:* **List<**[WeaponEffect](https://www.notion.so/WeaponEffect-eeba36844bcb468297f3330bc7490d05)**>** (x.size ≥ 0)
 */

class Weapon(
    val id: String = UUID.randomUUID().toString(),
    var name: String,
    var description: String = "",
    val value: Long = 0,
    val image: String = "",
    val rarity: ItemRarity = ItemRarity.BASIC,
    val damageValues: DamageValues,
    val energyValues: EnergyValues,
    val weaponType: WeaponType,
    val equipmentExperience: EquipmentExperience,
    val weaponEffects: List<WeaponEffect>
)