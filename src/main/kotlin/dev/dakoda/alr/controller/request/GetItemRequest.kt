package dev.dakoda.alr.controller.request

import com.fasterxml.jackson.annotation.JsonProperty

inline class GetItemRequest(
    @JsonProperty("id") val id: String
)