package dev.dakoda.alr.character.stats

import dev.dakoda.alr.character.stats.Stats.Type.BLOCK_CHANCE
import dev.dakoda.alr.character.stats.Stats.Type.CLARITY_CHANCE
import dev.dakoda.alr.character.stats.Stats.Type.COURAGE
import dev.dakoda.alr.character.stats.Stats.Type.CRITICAL_CHANCE
import dev.dakoda.alr.character.stats.Stats.Type.CRITICAL_DAMAGE
import dev.dakoda.alr.character.stats.Stats.Type.DEXTERITY
import dev.dakoda.alr.character.stats.Stats.Type.DODGE_CHANCE
import dev.dakoda.alr.character.stats.Stats.Type.HEALTH
import dev.dakoda.alr.character.stats.Stats.Type.HEALTH_MAX
import dev.dakoda.alr.character.stats.Stats.Type.INTELLIGENCE
import dev.dakoda.alr.character.stats.Stats.Type.MANA
import dev.dakoda.alr.character.stats.Stats.Type.MANA_MAX

class StatsDiffs {

    var stats = mutableMapOf(
        HEALTH to 0.0, MANA to 0.0,
        HEALTH_MAX to 0.0, MANA_MAX to 0.0,
        COURAGE to 0.0, DEXTERITY to 0.0, INTELLIGENCE to 0.0,
        CRITICAL_DAMAGE to 0.0, CRITICAL_CHANCE to 0.0, BLOCK_CHANCE to 0.0, DODGE_CHANCE to 0.0, CLARITY_CHANCE to 0.0
    )
}