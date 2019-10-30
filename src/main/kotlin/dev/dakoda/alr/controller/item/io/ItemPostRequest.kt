package dev.dakoda.alr.controller.item.io

import com.fasterxml.jackson.annotation.JsonProperty
import dev.dakoda.alr.domain.item.ItemType

data class ItemPostRequest(
    @field:JsonProperty(required = true) val name: String,
    @field:JsonProperty(required = true) val type: ItemType,
    @field:JsonProperty(required = false) val description: String = "",
    @field:JsonProperty(required = false) val value: Int = 0,
    @field:JsonProperty(required = false) val damage: Int = 0,
    @field:JsonProperty(required = false) val protection: Int = 0,
    @field:JsonProperty(required = false) val courage: Int = 0,
    @field:JsonProperty(required = false) val dexterity: Int = 0,
    @field:JsonProperty(required = false) val wisdom: Int = 0,
    @field:JsonProperty(required = false) val health: Int = 0,
    @field:JsonProperty(required = false) val mana: Int = 0
) {
    companion object
}