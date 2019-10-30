package dev.dakoda.alr.service

import dev.dakoda.alr.domain.item.Item
import dev.dakoda.alr.repository.service.ItemDataService
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class ItemService(
    private val dataService: ItemDataService
) {

    fun all(): List<Item> = dataService.all()

    operator fun get(id: String): Item {
        return dataService.get(id)
    }

    fun save(item: Item) {
        if (!item.hasId()) {
            item.id = UUID.randomUUID().toString()
        }
        dataService.save(item)
    }
}