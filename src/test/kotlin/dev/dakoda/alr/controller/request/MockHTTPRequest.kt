package dev.dakoda.alr.controller.request

import dev.dakoda.alr.domain.Mocked

class MockHTTPRequest {

    companion object {

        fun getItem(
            id: String = Mocked.junk().id
        ) = GetItemRequest(id = id)
    }
}