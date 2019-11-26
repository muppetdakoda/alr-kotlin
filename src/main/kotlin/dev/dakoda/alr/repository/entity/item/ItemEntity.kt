package dev.dakoda.alr.repository.entity.item

import au.com.console.kassava.kotlinEquals
import au.com.console.kassava.kotlinToString
import dev.dakoda.alr.domain.item.ItemType
import java.util.Objects
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

    type: ItemType,

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

    @Column(name = "ITEM_TYPE")
    val type: String = type.name

    private val props = arrayOf(
        ItemEntity::id, ItemEntity::name, ItemEntity::type, ItemEntity::description, ItemEntity::value, ItemEntity::damage,
        ItemEntity::protection, ItemEntity::courage, ItemEntity::dexterity, ItemEntity::wisdom, ItemEntity::health,
        ItemEntity::mana
    )

    override fun equals(other: Any?) = kotlinEquals(other, props)

    override fun toString() = kotlinToString(props)

    override fun hashCode() = Objects.hash(*props)

    companion object
}