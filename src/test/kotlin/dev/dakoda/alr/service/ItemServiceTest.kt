package dev.dakoda.alr.service

import dev.dakoda.alr.domain.Mocked
import dev.dakoda.alr.repository.service.ItemDataService
import dev.dakoda.dassert.dassert
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import io.mockk.just
import io.mockk.runs
import io.mockk.verify
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
class ItemServiceTest {

    @InjectMockKs
    lateinit var service: ItemService

    @MockK
    lateinit var dataService: ItemDataService

    @Test
    fun `When getting an item, then the item is retrieved from the data service`() {
        val item = Mocked.junk()

        every { dataService.getItem(any()) } returns item

        val responseItem = service.getItem(item.id)
        with (responseItem) {
            dassert {
                this@with equals item
            }
        }
    }

    @Test
    fun `When saving an item, then a call is made to the data service to save the item`() {
        val item = Mocked.junk()

        every { dataService.saveItem(any()) } just runs

        service.saveItem(item)

        verify(exactly = 1) { dataService.saveItem(item) }
    }

    fun `When saving an item with no ID associated with it it is generated`() {
        val item = Mocked.junk(generateID = true)

        every { dataService.saveItem(any()) } just runs

        service.saveItem(item)

        verify(exactly = 1) { dataService.saveItem(item) }
    }

}