package com.nohex.aoc

abstract class DefaultNavigableItem : NavigableItem {
    private val _neighbours = mutableSetOf<NavigableItem>()
    val neighbours
        get() = _neighbours.toSet()

    /**
     * Lets the item know about an adjacent item.
     */
    override fun addNeighbour(neighbour: NavigableItem) {
        // If already a neighbour, exit.
        if (neighbour in _neighbours)
            return

        // If the neighbour exists...
        neighbour.let {
            // ... add a reference to it...
            _neighbours.add(it)
            // ... and let the neighbour know about this instance.
            it.addNeighbour(this)
        }
    }
}