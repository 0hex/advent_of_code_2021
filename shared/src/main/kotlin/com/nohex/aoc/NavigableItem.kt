package com.nohex.aoc

/** An element in a {@link NavigableItemSet} */
interface NavigableItem {
    /**
     *  Lets this map element know about an adjacent element (a [neighbour]).
     *  If the neighbour should be able to navigate back to this one,
     *  [canTrackBack] should be {@code true}.
     */
    fun addNeighbour(neighbour: NavigableItem, canTrackBack: Boolean = true)
}
