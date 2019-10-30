package dev.dakoda.alr.controller

import com.ninjasquad.springmockk.MockkBean
import dev.dakoda.alr.controller.item.ItemController
import dev.dakoda.alr.domain.item.Item
import dev.dakoda.alr.mocked
import dev.dakoda.alr.parse
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

    @MockkBean
    lateinit var service: ItemService

    @Test
    fun `When hitting the item endpoint with a valid item id path variable, then receive a 200 OK response and an item`() {
        val item = Item.mocked()

        every { service[any()] } returns item
        val result = mockMVC.get("/item/${item.id}") {
            contentType = MediaType.APPLICATION_JSON
            accept = MediaType.APPLICATION_JSON
        }.andReturn()

        with(result) result@{
            dassert {
                response.status equals 200

                val itemResponse = parse<Item>()
                itemResponse.id equals item.id
            }
        }
    }

    // TODO
//    @Test
//    fun `When saving an item with a valid request body, then receive a 201 Created response`() {
//        val itemPostRequest = ItemPostRequest.mocked()
//        val parsedItem = Item.mocked()
//
//        every { service.save(any()) } just runs
//        val result = mockMVC.post("/item") {
//            contentType = MediaType.APPLICATION_JSON
//            content = itemPostRequest
//            accept = MediaType.APPLICATION_JSON
//        }.andReturn()
//
//        with(result) {
//            dassert { response.status equals 201 }
//        }
//    }
}