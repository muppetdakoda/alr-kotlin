package dev.dakoda.alr.combat

import dev.dakoda.alr.character.inventory.item.Weapon
import dev.dakoda.alr.character.stats.StatsService

object CombatService {

    fun attack(attacker: Combatant, receiver: Combatant) {
        // TODO
    }

    fun spell(user: Combatant, spell: Spell, receiver: Combatant) {
        // TODO
        spell.props.forEach {

        }
    }

    enum class Effect {
        CRITICAL, BLEED, POISON, DRAIN, REJUVENATION;

        companion object {

            // Deal increased physical damage
            fun critical(attacker: Combatant, receiver: Combatant) {
                val critChance = attacker.stats.criticalChance
                with(attacker.equipment) {
                    val baseDamage = attacker.phys

                    val additiveCrit =
                        (if (isHoldingDoubleHanded) mainHand.critDamage else (mainHand.critDamage + offHand.critDamage)) + attacker.stats.criticalDamage
                    val crit = baseDamage * (1.5 + additiveCrit)
                    StatsService.applyHealthChanges(receiver.stats, Damage.physical(crit))
                }
            }

            val Combatant.phys get() = with(this.equipment) {
                return@with if (isHoldingDoubleHanded) mainHand.phys else (mainHand.phys + offHand.phys)
            }

            val Combatant.cond get() = with(this.equipment) {
                return@with if (isHoldingDoubleHanded) mainHand.cond else (mainHand.cond + offHand.cond)
            }

            val Combatant.ether get() = with(this.equipment) {
                return@with if (isHoldingDoubleHanded) mainHand.ether else (mainHand.ether + offHand.ether)
            }

            private val Weapon.phys get() = this.damage.physical

            private val Weapon.cond get() = this.damage.conditional

            private val Weapon.ether get() = this.damage.ethereal

            private val Weapon.critDamage get() = this.statBonus.critDamage
        }
    }
}