package dev.dakoda.alr.service

import dev.dakoda.alr.domain.item.Item
import dev.dakoda.alr.repository.service.ItemDataService
import org.springframework.stereotype.Service

@Service
class ItemService(
    private val dataService: ItemDataService
) {

    fun getItem(id: String): Item {
        return dataService.getItem(id)
    }
}