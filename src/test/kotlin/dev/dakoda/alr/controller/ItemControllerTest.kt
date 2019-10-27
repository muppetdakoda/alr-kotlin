package dev.dakoda.alr.controller

import dev.dakoda.alr.controller.request.MockHTTPRequest
import dev.dakoda.alr.domain.MockItem
import dev.dakoda.alr.service.ItemService
import dev.dakoda.dassert.dassert
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

class ItemControllerTest {

    @Autowired
    @InjectMockKs
    lateinit var controller: ItemController

    @MockK
    lateinit var service: ItemService

    @Test
    fun `When hitting the item endpoint with a valid request body and a valid item ID, then receive a 200 OK response and an item`() {
        val itemRequest = MockHTTPRequest.getItem()

        every { service.getItem(any()) } returns MockItem.generic()
        val response = controller.getItem(itemRequest)

        with(response) {
            dassert {
                statusCode equals 200

                val itemResponse = body
                itemResponse.id equals itemRequest.id
            }
        }
    }
}