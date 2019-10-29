package dev.dakoda.alr.controller.request

import dev.dakoda.alr.domain.MockedItem

class MockHTTPRequest {

    companion object {

        fun getItem(
            id: String = MockedItem.junk().id
        ) = GetItemRequest(id = id)
    }
}