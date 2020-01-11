package dev.dakoda.alr.character.inventory.item

class Energies(
    var fire: Int,
    var ice: Int,
    var electric: Int,
    var force: Int,
    var divine: Int,
    var corruption: Int
) {
    companion object {
        val empty get() = Energies(0, 0, 0, 0, 0, 0)
    }
}