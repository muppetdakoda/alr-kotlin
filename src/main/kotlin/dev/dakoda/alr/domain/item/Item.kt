package dev.dakoda.alr.domain.item

import au.com.console.kassava.kotlinEquals
import au.com.console.kassava.kotlinToString
import dev.dakoda.alr.domain.Attributes
import dev.dakoda.alr.domain.Stats
import dev.dakoda.alr.domain.Vitals
import org.valiktor.functions.isNotBlank
import org.valiktor.functions.isPositiveOrZero
import org.valiktor.validate
import java.util.Objects

class Item(
    val id: String,
    val name: String,
    type: ItemType,
    val description: String,
    val value: Int,
    val attributes: Attributes,
    val stats: Stats,
    val vitals: Vitals
) {

    var type: String = type.name

    private val props = arrayOf(
        Item::id, Item::name, Item::type, Item::description, Item::value, Item::attributes, Item::stats, Item::vitals
    )

    init {
        validate(this) {
            validate(Item::id).isNotBlank()
            validate(Item::name).isNotBlank()
            validate(Item::value).isPositiveOrZero()
        }
    }

    override fun equals(other: Any?) = kotlinEquals(other, props)

    override fun toString() = kotlinToString(props)

    override fun hashCode() = Objects.hash(*props)

    companion object
}