package com.dakoda.alr.character

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
}