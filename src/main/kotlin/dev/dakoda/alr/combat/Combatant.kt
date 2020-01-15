package dev.dakoda.alr.combat

import dev.dakoda.alr.character.player.inventory.Equipment
import dev.dakoda.alr.character.stats.Stats

abstract class Combatant(
    val equipment: Equipment,
    val stats: Stats
)