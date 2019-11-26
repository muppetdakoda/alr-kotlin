package dev.dakoda.alr.controller.item.http

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper

interface ALRJson {

    fun json(): String = jacksonObjectMapper().writeValueAsString(this)
}