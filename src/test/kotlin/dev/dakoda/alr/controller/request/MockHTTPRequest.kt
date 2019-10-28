package dev.dakoda.alr.controller.request

import dev.dakoda.alr.domain.MockItem

class MockHTTPRequest {

    companion object {

        fun getItem(
            id: String = MockItem.generic().id
        ) = GetItemRequest(id = id)
    }
}