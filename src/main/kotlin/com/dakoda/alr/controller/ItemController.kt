package com.dakoda.alr.controller

import com.dakoda.alr.controller.request.GetItemRequest
import com.dakoda.alr.service.ItemService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestBody

@Controller
class ItemController(
    private val service: ItemService
) {

    @GetMapping("/item")
    fun getItem(@RequestBody request: GetItemRequest) {
        service.getItem(request.id)
    }
}