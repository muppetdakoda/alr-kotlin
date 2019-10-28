package dev.dakoda.alr.controller

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.ninjasquad.springmockk.MockkBean
import dev.dakoda.alr.controller.request.MockHTTPRequest
import dev.dakoda.alr.domain.MockItem
import dev.dakoda.alr.domain.item.Item
import dev.dakoda.alr.service.ItemService
import dev.dakoda.dassert.dassert
import io.mockk.every
import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get

@AutoConfigureMockMvc
@WebMvcTest(ItemController::class)
@ExtendWith(MockKExtension::class)
class ItemControllerTest @Autowired constructor(
    private val mockMVC: MockMvc
) {

    @MockkBean lateinit var service: ItemService

    @Test
    fun `When hitting the item endpoint with a valid request body and a valid item ID, then receive a 200 OK response and an item`() {
        val item = MockItem.generic()
        val itemRequest = MockHTTPRequest.getItem(item.id)

        every { service.getItem(any()) } returns item
        val result = mockMVC.get("/item/${itemRequest.id}") {
            contentType = MediaType.APPLICATION_JSON
            accept = MediaType.APPLICATION_JSON
        }.andReturn()

        with(result) {
            dassert {
                response.status equals 200

                val itemResponse = jacksonObjectMapper().readValue(response.contentAsString, Item::class.java)
                itemResponse.id equals itemRequest.id
            }
        }
    }
}