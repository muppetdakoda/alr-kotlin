package dev.dakoda.alr.service

import dev.dakoda.alr.domain.MockedItem
import dev.dakoda.alr.repository.service.ItemDataService
import dev.dakoda.dassert.dassert
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import io.mockk.just
import io.mockk.mockkStatic
import io.mockk.runs
import io.mockk.verify
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import java.util.UUID

@ExtendWith(MockKExtension::class)
class ItemServiceTest {

    @InjectMockKs
    lateinit var service: ItemService

    @MockK
    lateinit var dataService: ItemDataService

    @Test
    fun `When getting an item, then the item is retrieved from the data service`() {
        val item = MockedItem.junk()

        every { dataService.get(any()) } returns item

        val responseItem = service.getItem(item.id)
        with (responseItem) {
            dassert {
                this@with equals item
            }
        }
    }

    @Test
    fun `When saving an item, then a call is made to the data service to save the item`() {
        val item = MockedItem.junk()

        every { dataService.save(any()) } just runs

        service.saveItem(item)

        verify(exactly = 1) { dataService.save(item) }
    }

    @Test
    fun `When saving an item with no ID associated with it, then an ID is generated`() {
        val item = MockedItem.junk(generateID = false)

        every { dataService.save(any()) } just runs

        mockkStatic(UUID::class) {
            every { UUID.randomUUID().toString() } returns "e7d55e32-b0bf-4dc1-ba13-2083b33a9f14"
            service.saveItem(item)
            verify(exactly = 1) { UUID.randomUUID().toString() }
        }
    }
}