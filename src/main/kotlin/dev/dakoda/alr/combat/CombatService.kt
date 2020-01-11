package dev.dakoda.alr.combat

import dev.dakoda.alr.character.inventory.item.Weapon
import dev.dakoda.alr.character.stats.StatEffect.TickingEffect
import dev.dakoda.alr.character.stats.StatsService
import kotlin.random.Random

object CombatService {

    fun attack(attacker: Combatant, receiver: Combatant) {
        // TODO
    }

    fun spell(user: Combatant, spell: Spell, receiver: Combatant) {
        // TODO
        Effect.rejuvenation(receiver, 0.0, 0)
    }

    enum class Effect {
        CRITICAL, BLEED, POISON, DRAIN, REJUVENATION;

        companion object {

            // Deal increased physical damage
            fun critical(attacker: Combatant, receiver: Combatant) {
                val critChance = attacker.stats.critChanceBase
                with(attacker.equipment) {
                    val baseDamage = attacker.phys

                    val additiveCrit =
                        (if (isHoldingDoubleHanded) mainHand.critDamage else (mainHand.critDamage + offHand.critDamage)) + attacker.stats.critDamageBase
                    val crit = baseDamage * (1.5 + additiveCrit)
                    StatsService.applyHealthChanges(receiver.stats, Damages.physical(crit))
                }
            }

            // Apply a tick of 15% physical damage (or specified percent)
            // for 1 to 3 turns (or specified amount of turns)
            fun bleed(attacker: Combatant, receiver: Combatant, percent: Int = 15, turns: Int = 0) {
                val tick = (percent / 100) * attacker.phys
                val turnsCalc = turns.takeIf { it > 0 } ?: Random.nextInt(1, 4)
                StatsService.applyEffect(receiver.stats,TickingEffect.bleed(tick, turnsCalc))
            }

            // Apply a tick of 10% conditional damage (or specified percent)
            // for 2 to 5 turns (or specified amount of turns)
            fun poison(attacker: Combatant, receiver: Combatant, percent: Int = 10, turns: Int = 0) {
                val tick = (percent / 100) * attacker.cond
                val turnsCalc = turns.takeIf { it > 0 } ?: Random.nextInt(2, 6)
                StatsService.applyEffect(receiver.stats, TickingEffect.poison(tick, turnsCalc))
            }

            // Apply a tick of regeneration
            // for a certain amount of turns and healing
            fun rejuvenation(receiver: Combatant, tick: Double, turns: Int) {
                StatsService.applyEffect(receiver.stats, TickingEffect.rejuvenation(tick, turns))
            }

            // Apply a tick of percentage-based regeneration
            // for a certain amount of turns and healing
            fun rejuvenationPercent(receiver: Combatant, percent: Int, turns: Int) {
                val tick = percent * receiver.stats.healthMax
                StatsService.applyEffect(receiver.stats, TickingEffect.rejuvenation(tick, turns))
            }

            private val Combatant.phys get() = with(this.equipment) {
                return@with if (isHoldingDoubleHanded) mainHand.phys else (mainHand.phys + offHand.phys)
            }

            private val Combatant.cond get() = with(this.equipment) {
                return@with if (isHoldingDoubleHanded) mainHand.cond else (mainHand.cond + offHand.cond)
            }

            private val Combatant.ether get() = with(this.equipment) {
                return@with if (isHoldingDoubleHanded) mainHand.ether else (mainHand.ether + offHand.ether)
            }

            private val Weapon.phys get() = this.damages.physical

            private val Weapon.cond get() = this.damages.conditional

            private val Weapon.ether get() = this.damages.ethereal

            private val Weapon.critDamage get() = this.statBonus.critDamage
        }
    }
}