package dev.dakoda.alr.controller

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import dev.dakoda.alr.controller.request.MockHTTPRequest
import dev.dakoda.alr.domain.item.Item
import dev.dakoda.dassert.dassert
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get

@AutoConfigureMockMvc
@SpringBootTest
class ItemControllerTestIT @Autowired constructor(
    private val mockMVC: MockMvc
) {

//    @Test
//    fun `When hitting the item endpoint with a valid request body and a valid item ID, then receive a 200 OK response and an item`() {
//        val itemRequest = MockHTTPRequest.getItem()
//
//        val result = mockMVC.get("/item") {
//            contentType = APPLICATION_JSON
//            content = itemRequest
//        }.andReturn()
//
//        with(result) {
//            dassert {
//                val itemResponse: Item = jacksonObjectMapper().readValue(response.contentAsString, Item::class.java)
//
//                response.status equals 200
//                itemResponse.id equals itemRequest.id
//            }
//        }
//    }
}