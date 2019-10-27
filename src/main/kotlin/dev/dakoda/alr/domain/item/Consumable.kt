package dev.dakoda.alr.domain.item

import dev.dakoda.alr.domain.character.Stat
import org.valiktor.functions.isNotBlank
import org.valiktor.functions.isPositiveOrZero
import org.valiktor.validate

class Consumable(
    name: String,
    val stats: MutableList<Stat> = mutableListOf(),
    description: String = "",
    value: Int = 0
): Item(
    name = name,
    type = ItemType.CONSUMABLE,
    description = description,
    value = value
) {

    init {
        validate(this) {
            validate(Consumable::name).isNotBlank()
            validate(Consumable::value).isPositiveOrZero()
        }
    }
}