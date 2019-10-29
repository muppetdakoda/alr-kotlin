package dev.dakoda.alr.repository.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "ALR_ITEM")
class ItemEntity(

    @Id
    @Column(name = "ITEM_ID", nullable = false)
    val id: String,

    @Column(name = "ITEM_NAME")
    val name: String,

    @Column(name = "ITEM_TYPE")
    val type: String,

    @Column(name = "ITEM_DESCRIPTION")
    val description: String = "",

    @Column(name = "ITEM_VALUE")
    val value: Int = 0,

    @Column(name = "ITEM_DAMAGE")
    val damage: Int = 0,

    @Column(name = "ITEM_PROTECTION")
    val protection: Int = 0,

    @Column(name = "ITEM_STAT_COURAGE")
    val courage: Int = 0,

    @Column(name = "ITEM_STAT_DEXTERITY")
    val dexterity: Int = 0,

    @Column(name = "ITEM_STAT_WISDOM")
    val wisdom: Int = 0,

    @Column(name = "ITEM_STAT_HEALTH")
    val health: Int = 0,

    @Column(name = "ITEM_STAT_MANA")
    val mana: Int = 0
) {
    companion object
}