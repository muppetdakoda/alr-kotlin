package dev.dakoda.alr.domain.item

import org.valiktor.functions.isNotBlank
import org.valiktor.functions.isPositiveOrZero
import org.valiktor.validate

class Item(
    val name: String,
    val type: ItemType,
    val description: String,
    val value: Int,
    val damage: Int = 0,
    val protection: Int = 0,
    val courage: Int = 0,
    val dexterity: Int = 0,
    val wisdom: Int = 0,
    val health: Int = 0,
    val mana: Int = 0
) {

    lateinit var id: String

    fun hasId(): Boolean = ::id.isInitialized

    init {
        @Suppress("LeakingThis") validate(this) {
            validate(Item::name).isNotBlank()
            validate(Item::value).isPositiveOrZero()
            validate(Item::damage).isPositiveOrZero()
            validate(Item::protection).isPositiveOrZero()
        }
    }

    override fun equals(other: Any?): Boolean {
        return other is Item && true
            .and(
                if (hasId() && other.hasId()) {
                    other.id == this.id
                } else {
                    !hasId() && !other.hasId()
                }
            )
            .and(other.name == this.name)
            .and(other.type == this.type)
            .and(other.description == this.description)
            .and(other.value == this.value)
            .and(other.damage == this.damage)
            .and(other.protection == this.protection)
            .and(other.courage == this.courage)
            .and(other.dexterity == this.dexterity)
            .and(other.wisdom == this.dexterity)
            .and(other.health == this.health)
            .and(other.mana == this.mana)
            .and(other.hashCode() == this.hashCode())
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + type.hashCode()
        result = 31 * result + description.hashCode()
        result = 31 * result + value
        if (hasId()) result = 31 * result + id.hashCode()
        return result
    }

    companion object
}