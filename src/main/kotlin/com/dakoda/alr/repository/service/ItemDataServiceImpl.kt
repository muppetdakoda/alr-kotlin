package com.dakoda.alr.repository.service

import com.dakoda.alr.domain.item.Item
import com.dakoda.alr.domain.item.ItemType
import com.dakoda.alr.exception.ItemNotFoundException
import com.dakoda.alr.repository.ItemRepository
import com.dakoda.alr.repository.entity.ItemEntity
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

    private fun ItemEntity.convert() = Item(
        name = name,
        type = ItemType.valueOf(type),
        description = description,
        value = value
    )
}