package dev.dakoda.alr.repository.service

import dev.dakoda.alr.domain.item.Item
import dev.dakoda.alr.domain.item.ItemType
import dev.dakoda.alr.exception.ItemNotFoundException
import dev.dakoda.alr.repository.ItemRepository
import dev.dakoda.alr.repository.entity.ItemEntity
import org.springframework.stereotype.Service

@Service
class ItemDataServiceImpl(
    private val repository: ItemRepository
): ItemDataService {

    override fun getItem(id: String): Item {
        val repositoryResponse = repository.findById(id)
        if (repositoryResponse.isPresent) {
            return repositoryResponse.get().convert()
        } else throw ItemNotFoundException()
    }

    override fun saveItem(item: Item) {
        repository.save(item.convert())
    }

    private fun ItemEntity.convert() = Item(
        name = name,
        type = ItemType.valueOf(type),
        description = description,
        value = value
    ).apply {
        this.ID = this@convert.ID
    }

    private fun Item.convert() = ItemEntity(
        ID = ID,
        name = name,
        type = type.name,
        description = description,
        value = value
    )
}