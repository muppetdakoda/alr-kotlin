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
    val ID: String,

    @Column(name = "ITEM_NAME")
    val name: String,

    @Column(name = "ITEM_TYPE")
    val type: String,

    @Column(name = "ITEM_DESCRIPTION")
    val description: String,

    @Column(name = "ITEM_VALUE")
    val value: String
)