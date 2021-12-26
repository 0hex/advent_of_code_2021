package com.nohex.aoc.day11

/** An octopus with an associated energy level, and knowledge about its neighbours */
class Octopus(var level: Int) {
    private val _neighbours = mutableSetOf<Octopus>()
    val neighbours
        get() = _neighbours.toSet()

    /**
     * Lets the octopus know about a nearby octopus.
     */
    fun addNeighbour(neighbour: Octopus?) {
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

    /**
     * Increases the octopus's energy level.
     */
    fun increaseLevel(flashers: MutableSet<Octopus>) {
        if (this !in flashers)
            when (level) {
                // If the energy level is 9, flash.
                9 -> flash(flashers)
                // Otherwise, just increase the energy level.
                else -> level++
            }
    }

    /**
     * Make an octopus flash, i.e. deplete its own energy and increase its neighbours'.
     */
    private fun flash(flashers: MutableSet<Octopus>) {
        // This octopus is now a flasher.
        flashers += this
        // Increase the neighbours' energy level.
        _neighbours.forEach { it.increaseLevel(flashers) }
        // finally, reset this octopus's energy level.
        level = 0
    }
}