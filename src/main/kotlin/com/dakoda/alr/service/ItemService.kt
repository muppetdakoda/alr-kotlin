package com.dakoda.alr.service

import com.dakoda.alr.domain.item.Item
import com.dakoda.alr.repository.service.ItemDataService
import org.springframework.stereotype.Service

@Service
class ItemService(
    private val dataService: ItemDataService
) {

    fun getItem(id: String): Item {
        return dataService.getItem(id)
    }
}