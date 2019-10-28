package dev.dakoda.alr.domain.item

import dev.dakoda.alr.domain.character.Stat
import org.valiktor.functions.isNotBlank
import org.valiktor.functions.isPositiveOrZero
import org.valiktor.validate

class Accessory(
    name: String,
    val stats: MutableList<Stat> = mutableListOf(),
    description: String = "",
    value: Int = 20
): Item(
    name = name,
    type = ItemType.ACCESSORY,
    description = description,
    value = value
) {

    init {
        validate(this) {
            validate(Accessory::name).isNotBlank()
            validate(Accessory::value).isPositiveOrZero()
        }
    }
}