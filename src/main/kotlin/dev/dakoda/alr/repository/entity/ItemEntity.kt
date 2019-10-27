package dev.dakoda.alr.repository.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "ALR_ITEM")
class ItemEntity(

    @Id
    @Column(name = "itemID", nullable = false)
    val id: String,

    @Column(name = "itemName", nullable = false)
    val name: String,

    @Column(name = "itemType", nullable = false)
    val type: String,

    @Column(name = "itemDescription", nullable = false)
    val description: String,

    @Column(name = "itemValue", nullable = false)
    val value: Int
)