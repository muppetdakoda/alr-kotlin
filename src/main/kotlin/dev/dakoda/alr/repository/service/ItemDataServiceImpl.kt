package dev.dakoda.alr.repository.service

import dev.dakoda.alr.domain.item.Item
import dev.dakoda.alr.domain.item.ItemType
import dev.dakoda.alr.exception.ItemNotFoundException
import dev.dakoda.alr.repository.GameDefault
import dev.dakoda.alr.repository.ItemRepository
import dev.dakoda.alr.repository.entity.ItemEntity
import org.springframework.stereotype.Service

@Service
class ItemDataServiceImpl(
    private val repository: ItemRepository
): ItemDataService {

    // TODO: fix the data.sql file
    init {
        repository.save(GameDefault.itemEntity)
    }

    override fun getItem(id: String): Item {
        val repositoryResponse = repository.findById(id)
        if (repositoryResponse.isPresent) {
            return repositoryResponse.get().convert()
        } else throw ItemNotFoundException()

    }

    private fun ItemEntity.convert() = Item(
        name = name,
        type = ItemType.valueOf(type),
        description = description,
        value = value
    ).apply {
        this.id = this@convert.id
    }

    private fun Item.convert() = ItemEntity(
        id = id,
        name = name,
        type = type.name,
        description = description,
        value = value
    )
}