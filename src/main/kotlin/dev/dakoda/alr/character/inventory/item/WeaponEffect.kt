package dev.dakoda.alr.character.inventory.item

import dev.dakoda.alr.character.stats.Stats

enum class WeaponEffect(
    val effect: (weapon: Weapon, stats: Stats) -> Unit
) {
    BLEED({ weapon: Weapon, stats: Stats ->
        
    })
}