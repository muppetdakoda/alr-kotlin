package com.dakoda.alr.domain.character

import org.valiktor.functions.isPositiveOrZero
import org.valiktor.validate

class Stat(
    val type: StatType,
    val value: Float
) {

    init {
        validate(this) {
            validate(Stat::value).isPositiveOrZero()
        }
    }

    override fun equals(other: Any?): Boolean {
        return other is Stat &&
                other.type == this.type &&
                other.value == this.value
    }

    override fun hashCode(): Int {
        return type.ordinal.hashCode() + value.hashCode()
    }
}