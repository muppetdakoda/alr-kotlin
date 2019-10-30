package dev.dakoda.alr.controller.item

import dev.dakoda.alr.controller.item.io.ItemGetRequest
import dev.dakoda.alr.controller.item.io.ItemGetRequestShort
import dev.dakoda.alr.controller.item.io.ItemPostRequest
import dev.dakoda.alr.service.ItemService
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@Controller
class ItemController(
    private val service: ItemService
) {

    @GetMapping("/item")
    fun all(): ResponseEntity<List<ItemGetRequestShort>> {
        return ResponseEntity.status(200).body(
            ItemParser.mitigatedCollective(service.all())
        )
    }

    @GetMapping("/item_verbose")
    fun allVerbose(): ResponseEntity<List<ItemGetRequest>> {
        return ResponseEntity.status(200).body(
            ItemParser.mitigatedCollectiveVerbose(service.all())
        )
    }

    @GetMapping("/item/{id}")
    fun get(@PathVariable id: String): ResponseEntity<ItemGetRequest> {
        return ResponseEntity.status(200).body(ItemParser.itemResponse(service[id]))
    }

    @PostMapping("/item")
    fun save(@RequestBody request: ItemPostRequest): ResponseEntity<Nothing> {
        service.save(ItemParser.parseItem(request))
        return ResponseEntity.status(201).build()
    }
}