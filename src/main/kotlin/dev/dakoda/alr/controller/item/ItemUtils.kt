package dev.dakoda.alr.controller.item

import dev.dakoda.alr.domain.item.ItemType
import kotlin.random.Random
import kotlin.reflect.KClass

interface ItemUtils {

    companion object {

        fun generateID() = ("${Random(28000_28030).nextInt()}x${Random(562_5462).nextInt()}")

        fun randomType() = ItemType::class.random()
    }
}

fun <T: Enum<*>> KClass<T>.random(): T {
    return this.java.enumConstants[Random(this.java.enumConstants.size).nextInt()]
}