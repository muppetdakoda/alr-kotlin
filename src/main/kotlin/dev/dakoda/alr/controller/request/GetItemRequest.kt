package dev.dakoda.alr.controller.request

import com.fasterxml.jackson.annotation.JsonProperty

class GetItemRequest(
    @JsonProperty("id") val id: String
) {

    override fun equals(other: Any?): Boolean {
        return other is GetItemRequest && true
            .and(other.id == this.id)
            .and(other.hashCode() == this.hashCode())
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}