package dev.dakoda.alr.domain

import dev.dakoda.alr.domain.character.Stat
import dev.dakoda.alr.domain.character.StatType

class MockCharacter {

    companion object {

        fun stat(
            type: StatType = StatType.COURAGE,
            value: Float = 20f
        ) = Stat(
            type = type,
            value = value
        )

        val stats: MutableList<Stat>
            get() = StatType.values().map {
                stat(it, 20f)
            }.toMutableList()
    }
}