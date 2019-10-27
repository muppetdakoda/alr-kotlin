package dev.dakoda.alr.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(value = HttpStatus.NOT_FOUND)
class ItemNotFoundException(message: String = incorrectID) : RuntimeException(message) {

    companion object {

        const val incorrectID = "Provided ID did not correlate to a stored item"
    }
}