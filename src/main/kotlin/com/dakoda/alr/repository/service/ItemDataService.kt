package com.dakoda.alr.repository.service

import com.dakoda.alr.domain.item.Item

interface ItemDataService {

     fun getItem(id: String): Item
}