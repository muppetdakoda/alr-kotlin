package dev.dakoda.alr.domain

import dev.dakoda.alr.domain.item.PlayerItemRecord

class Player(
    val id: String
) {

    lateinit var items: List<PlayerItemRecord>
}