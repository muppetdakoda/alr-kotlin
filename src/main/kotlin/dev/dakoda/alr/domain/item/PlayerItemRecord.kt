package dev.dakoda.alr.domain.item

import dev.dakoda.alr.domain.Player

class PlayerItemRecord(

    val player: Player,
    val item: Item,
    val quantity: Int
)