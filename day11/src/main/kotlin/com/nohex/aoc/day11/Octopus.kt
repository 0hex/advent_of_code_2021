package com.nohex.aoc.day11

import com.nohex.aoc.DefaultNavigableItem

/** An octopus with an associated energy level, and knowledge about its neighbours */
class Octopus(var level: Int) : DefaultNavigableItem() {

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
        neighbours
            .filterIsInstance<Octopus>()
            .forEach { it.increaseLevel(flashers) }
        // finally, reset this octopus's energy level.
        level = 0
    }
}