package dev.dakoda.alr.controller.item

import dev.dakoda.alr.controller.item.http.ItemResponse
import dev.dakoda.alr.controller.item.http.ItemResponseShort
import dev.dakoda.alr.service.ItemService
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@Controller
class ItemController(
    private val service: ItemService
) {

    @GetMapping("/item")
    fun all(): ResponseEntity<List<ItemResponseShort>> {
        return ResponseEntity.status(200).body(
            HTTPParseItem.domainList(service.all())
        )
    }

    @GetMapping("/item_verbose")
    fun allVerbose(): ResponseEntity<List<ItemResponse>> {
        return ResponseEntity.status(200).body(
            HTTPParseItem.domainListVerbose(service.all())
        )
    }

    @GetMapping("/item/{id}")
    fun get(@PathVariable id: String): ResponseEntity<ItemResponse> {
        return ResponseEntity.status(200).body(ItemResponse(service[id]))
    }
}