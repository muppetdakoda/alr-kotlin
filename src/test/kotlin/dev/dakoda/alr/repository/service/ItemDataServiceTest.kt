package dev.dakoda.alr.repository.service

import dev.dakoda.alr.convert
import dev.dakoda.alr.domain.item.Item
import dev.dakoda.alr.exception.ItemNotFoundException
import dev.dakoda.alr.mocked
import dev.dakoda.alr.repository.ItemRepository
import dev.dakoda.alr.repository.entity.ItemEntity
import dev.dakoda.dassert.dassert
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import io.mockk.verify
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.extension.ExtendWith
import java.util.Optional

@ExtendWith(MockKExtension::class)
class ItemDataServiceTest {

    @InjectMockKs
    lateinit var dataService: ItemDataService

    @MockK
    lateinit var repository: ItemRepository

    @Test
    fun `When getting an item with a valid ID, return an item`() {
        val itemEntity = ItemEntity.mocked()

        every { repository.findById(any()) } returns Optional.of(itemEntity)

        val response = dataService.get(itemEntity.id)
        with(response) {
            dassert {
                id equals itemEntity.id
                name equals itemEntity.name
                type.name equals itemEntity.type
                description equals itemEntity.description
                value equals itemEntity.value
            }
        }
    }

    @Test
    fun `When getting an item with an invalid ID, throw an item not found exception`() {
        val itemEntity = Item.mocked()

        every { repository.findById(any()) } returns Optional.empty()

        assertThrows<ItemNotFoundException> {
            dataService.get(itemEntity.id)
        }
    }

    @Test
    fun `When saving a new item, then a call is made to save the item to the repository`() {
        val item = Item.mocked()
        val itemEntity = item.convert()

        every { repository.save(any<ItemEntity>()) } returns itemEntity

        dataService.save(item)

        verify(exactly = 1) { repository.save(any<ItemEntity>()) }
    }
}