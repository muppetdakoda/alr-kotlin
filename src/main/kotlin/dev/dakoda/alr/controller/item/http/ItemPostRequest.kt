package dev.dakoda.alr.controller.item.http

import com.fasterxml.jackson.annotation.JsonProperty

class ItemPostRequest(
    @JsonProperty("name", required = true) val name: String,
    @JsonProperty("type", required = true) val type: String,
    @JsonProperty("description", required = true) val description: String,
    @JsonProperty("value", required = true) val value: Int,
    @JsonProperty("damage", required = false) val damage: Int = 0,
    @JsonProperty("protection", required = false) val protection: Int = 0,
    @JsonProperty("courage", required = false) val courage: Int = 0,
    @JsonProperty("dexterity", required = false) val dexterity: Int = 0,
    @JsonProperty("wisdom", required = false) val wisdom: Int = 0,
    @JsonProperty("health", required = false) val health: Int = 0,
    @JsonProperty("mana", required = false) val mana: Int = 0
)