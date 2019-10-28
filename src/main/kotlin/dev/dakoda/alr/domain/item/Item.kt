package dev.dakoda.alr.domain.item

import org.valiktor.functions.isNotBlank
import org.valiktor.functions.isPositiveOrZero
import org.valiktor.validate

open class Item(
    val name: String,
    val type: ItemType = ItemType.GENERIC,
    val description: String = "",
    val value: Int = 0
) {

    lateinit var ID: String

    val hasID: Boolean = ::ID.isInitialized

    init {
        @Suppress("LeakingThis") validate(this) {
            validate(Item::name).isNotBlank()
            validate(Item::value).isPositiveOrZero()
        }
    }

    override fun equals(other: Any?): Boolean {
        return other is Item &&
                other.ID == this.ID &&
                other.name == this.name &&
                other.type == this.type &&
                other.description == this.description &&
                other.value == this.value
    }

    override fun hashCode(): Int {
        return super.hashCode()
    }
}