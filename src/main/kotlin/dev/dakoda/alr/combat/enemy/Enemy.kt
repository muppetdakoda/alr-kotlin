package dev.dakoda.alr.combat.enemy

import dev.dakoda.alr.character.player.inventory.Equipment
import dev.dakoda.alr.character.stats.Stats
import dev.dakoda.alr.combat.Combatant

class Enemy(
    equipment: Equipment,
    stats: Stats
) : Combatant(equipment, stats)