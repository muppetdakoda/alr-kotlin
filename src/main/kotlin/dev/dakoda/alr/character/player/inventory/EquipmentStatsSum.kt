package dev.dakoda.alr.character.player.inventory

object EquipmentStatsSum {

    fun Equipment.sumMaxHealth(): Double {
        return (armours.map { it.value.statsDiffs.healthMaxDiff }.sum()) +
                (weapons.map { it.value.statsDiffs.healthMaxDiff }.sum())
    }

    fun Equipment.sumMaxMana(): Double {
        return (armours.map { it.value.statsDiffs.manaMaxDiff }.sum()) +
                (weapons.map { it.value.statsDiffs.manaMaxDiff }.sum())
    }

    fun Equipment.sumCourage(): Double {
        return (armours.map { it.value.statsDiffs.courageDiff }.sum()) +
                (weapons.map { it.value.statsDiffs.courageDiff }.sum())
    }

    fun Equipment.sumDexterity(): Double {
        return (armours.map { it.value.statsDiffs.dexterityDiff }.sum()) +
                (weapons.map { it.value.statsDiffs.dexterityDiff }.sum())
    }

    fun Equipment.sumIntelligence(): Double {
        return (armours.map { it.value.statsDiffs.intelligenceDiff }.sum()) +
                (weapons.map { it.value.statsDiffs.intelligenceDiff }.sum())
    }

    fun Equipment.sumCriticalDamage(): Double {
        return (armours.map { it.value.statsDiffs.critDamageDiff }.sum()) +
                (weapons.map { it.value.statsDiffs.critDamageDiff }.sum())
    }

    fun Equipment.sumCriticalChance(): Double {
        return (armours.map { it.value.statsDiffs.critChanceDiff }.sum()) +
                (weapons.map { it.value.statsDiffs.critChanceDiff }.sum())
    }

    fun Equipment.sumBlockChance(): Double {
        return (armours.map { it.value.statsDiffs.blockChanceDiff }.sum()) +
                (weapons.map { it.value.statsDiffs.blockChanceDiff }.sum())
    }

    fun Equipment.sumDodgeChance(): Double {
        return (armours.map { it.value.statsDiffs.dodgeChanceDiff }.sum()) +
                (weapons.map { it.value.statsDiffs.dodgeChanceDiff }.sum())
    }

    fun Equipment.sumClarityChance(): Double {
        return (armours.map { it.value.statsDiffs.clarityChanceDiff }.sum()) +
                (weapons.map { it.value.statsDiffs.clarityChanceDiff }.sum())
    }
}