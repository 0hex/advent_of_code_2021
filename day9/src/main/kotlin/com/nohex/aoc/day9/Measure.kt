package com.nohex.aoc.day9

/** A localised height measurement, along with a reference to nearby measurements. */
class Measure(val height: Int) {
    private val _neighbours = mutableSetOf<Measure>()
    val neighbours
        get() = _neighbours.toSet()

    fun addNeighbour(neighbour: Measure?) {
        // If already a neighbour, exit.
        if (neighbour in _neighbours)
            return

        // If the neighbour exists...
        neighbour?.let {
            // ... add a reference to it...
            _neighbours.add(it)
            // ... and let the neighbour know about this instance.
            it.addNeighbour(this)
        }
    }
}