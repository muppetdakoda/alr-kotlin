package dev.dakoda.alr.controller

import dev.dakoda.alr.domain.item.Item
import dev.dakoda.alr.service.ItemService
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@Controller
class ItemController(
    private val service: ItemService
) {

    @GetMapping("/item/{requestID}")
    fun getItem(@PathVariable requestID: String): ResponseEntity<Item> {
        val item = service.getItem(requestID)

        val response = ResponseEntity.status(200).body(item)
        return response
    }
}