package dev.dakoda.alr.repository.service

interface DataService<T> {

    fun get(id: String): T

    fun save(item: T)
}