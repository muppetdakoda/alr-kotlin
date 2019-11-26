package dev.dakoda.alr.repository.service

import dev.dakoda.alr.domain.item.Item
import dev.dakoda.alr.domain.item.ItemType
import dev.dakoda.alr.exception.ItemNotFoundException
import dev.dakoda.alr.repository.ItemRepository
import dev.dakoda.alr.repository.entity.item.ItemEntity
import org.springframework.stereotype.Service

@Service
class ItemDataService(
    private val repository: ItemRepository
) : DataService<Item> {

    override operator fun get(id: String): Item {
        val repositoryResponse = repository.findById(id)
        if (repositoryResponse.isPresent) {
            return repositoryResponse.get().convert()
        } else throw ItemNotFoundException()
    }

    override fun save(obj: Item) {
        repository.save(obj.convert())
    }

    override fun all(): List<Item> = repository.findAll().map { it.convert() }

    fun ItemEntity.convert() = Item(
        id, name, ItemType.valueOf(type), description, value,
        damage, protection,
        courage, dexterity, wisdom,
        health, mana
    )

    fun Item.convert() = ItemEntity(
        id, name, type, description, value,
        damage, protection,
        courage, dexterity, wisdom,
        health, mana
    )
}