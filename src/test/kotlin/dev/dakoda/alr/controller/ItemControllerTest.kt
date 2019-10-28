package dev.dakoda.alr.controller

import dev.dakoda.alr.controller.request.MockHTTPRequest
import dev.dakoda.alr.domain.MockItem
import dev.dakoda.alr.service.ItemService
import dev.dakoda.dassert.dassert
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.http.HttpStatus

@ExtendWith(MockKExtension::class)
class ItemControllerTest {

    @InjectMockKs
    lateinit var controller: ItemController

    @MockK
    lateinit var service: ItemService

    @Test
    fun `When hitting the item endpoint with a valid request body and a valid item ID, then receive a 200 OK response and an item`() {
        val item = MockItem.generic()
        val itemRequest = MockHTTPRequest.getItem(item.ID)

        every { service.getItem(any()) } returns item
        val response = controller.getItem(itemRequest)

        with(response) {
            dassert {
                statusCode equals HttpStatus.OK

                val itemResponse = body!!
                itemResponse.ID equals itemRequest.ID
            }
        }
    }
}