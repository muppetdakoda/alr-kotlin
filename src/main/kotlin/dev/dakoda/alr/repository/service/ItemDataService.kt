package dev.dakoda.alr.repository.service

import dev.dakoda.alr.domain.item.Item

interface ItemDataService {

    fun getItem(id: String): Item

    fun saveItem(item: Item)
}