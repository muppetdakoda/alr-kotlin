package dev.dakoda.alr.repository.entity

import dev.dakoda.alr.repository.entity.item.PlayerItemRecordEntity
import javax.persistence.Column
import javax.persistence.Id
import javax.persistence.OneToMany

class PlayerEntity(
    @Id
    @Column
    val id: String
) {

    @OneToMany(mappedBy = "")
    lateinit var items: List<PlayerItemRecordEntity>
}