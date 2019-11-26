package dev.dakoda.alr.repository.entity.item

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.IdClass

@Entity(name = "ALR_PLAYER_ITEM_RECORD")
@IdClass(PlayerItemRecordEntityPK::class)
class PlayerItemRecordEntity(
    @Id
    @Column(nullable = false)
    val playerID: String,

    @Id
    @Column(nullable = false)
    val itemID: String,

    @Column(nullable = false, updatable = true)
    var quantity: Int
)