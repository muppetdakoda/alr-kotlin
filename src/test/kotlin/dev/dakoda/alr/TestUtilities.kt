package dev.dakoda.alr

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.springframework.test.web.servlet.MvcResult

inline fun <reified T> MvcResult.parse(): T {
    return jacksonObjectMapper().readValue(this.response.contentAsString, T::class.java)
}