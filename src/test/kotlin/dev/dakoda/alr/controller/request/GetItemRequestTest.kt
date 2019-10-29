package dev.dakoda.alr.controller.request

import dev.dakoda.dassert.dassert
import org.junit.jupiter.api.Test

class GetItemRequestTest {

    @Test
    fun `When creating a get item request object, it is instantiated correctly`() {
        val getItemRequest: GetItemRequest? = MockedHTTP.getItemRequest(id = "1-2-3-4-5")

        with(getItemRequest!!) {
            dassert {
                id equals "1-2-3-4-5"
            }
        }
    }

    @Test
    fun `Equally instantiated request objects are equal`() {
        val first = MockedHTTP.getItemRequest(
            id = "1-2-3-4-5"
        )
        val second = MockedHTTP.getItemRequest(
            id = "1-2-3-4-5"
        )
        dassert {
            first equals second
        }
    }

    @Test
    fun `Unequally instantiated request objects are unequal`() {
        val first = MockedHTTP.getItemRequest(
            id = "5-4-3-2-1"
        )
        val second = MockedHTTP.getItemRequest(
            id = "1-2-3-4-5"
        )
        dassert {
            first isNotEqualTo second
        }
    }

    @Test
    fun `A GetItemRequest object can only be equal to another GetItemRequest object`() {
        val first = MockedHTTP.getItemRequest()
        val second = "GetItemRequest"

        dassert {
            first isNotEqualTo second
        }
    }
}