package com.nohex.aoc

/** An element in a {@link NavigableItemSet} */
interface NavigableItem {
    /** Lets this map element know about an adjacent element (a [neighbour]). */
    fun addNeighbour(neighbour: NavigableItem)
}
