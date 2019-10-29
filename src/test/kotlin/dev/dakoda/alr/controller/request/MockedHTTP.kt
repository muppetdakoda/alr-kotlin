package dev.dakoda.alr.controller.request

import dev.dakoda.alr.domain.item.Item
import dev.dakoda.alr.mocked


class MockedHTTP {

    companion object {

        fun getItemRequest(
            id: String = Item.mocked().id
        ) = GetItemRequest(id = id)
    }
}