package com.dakoda.alr

import com.dakoda.alr.character.Stat
import com.dakoda.alr.character.StatType

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