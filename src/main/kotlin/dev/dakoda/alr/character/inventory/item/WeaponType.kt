package dev.dakoda.alr.character.inventory.item

enum class WeaponType(
    val isDoubleHanded: Boolean = false
) {
    SWORD, AXE, DAGGER, WAND,
    GREATSWORD(true), GREATAXE(true), STAFF(true),
    BOW(true), PIKE(true), HAMMER(true);
}