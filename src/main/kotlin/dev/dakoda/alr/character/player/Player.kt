package dev.dakoda.alr.character.player

import dev.dakoda.alr.character.inventory.item.Equipment
import dev.dakoda.alr.character.stats.Stats
import dev.dakoda.alr.combat.Combatant

class Player(
    equipment: Equipment,
    stats: Stats
) : Combatant(equipment, stats) {

    var isInCombat: Boolean = false
}