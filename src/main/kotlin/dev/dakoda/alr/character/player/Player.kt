package dev.dakoda.alr.character.player

import dev.dakoda.alr.character.player.inventory.Equipment
import dev.dakoda.alr.character.player.inventory.Inventory
import dev.dakoda.alr.character.stats.Stats
import dev.dakoda.alr.combat.Combatant

class Player(
    equipment: Equipment,
    stats: Stats,
    inventory: Inventory
) : Combatant(equipment, stats) {

    var isInCombat: Boolean = false
}