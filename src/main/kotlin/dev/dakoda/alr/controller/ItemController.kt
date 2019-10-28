package dev.dakoda.alr.controller

import dev.dakoda.alr.controller.request.GetItemRequest
import dev.dakoda.alr.domain.item.Item
import dev.dakoda.alr.service.ItemService
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestBody

@Controller
class ItemController(
    private val service: ItemService
) {

    @GetMapping("/item")
    fun getItem(@RequestBody request: GetItemRequest): ResponseEntity<Item> {
        val item = service.getItem(request.ID)

        val response = ResponseEntity.status(200).body(item)
        return response
    }
}