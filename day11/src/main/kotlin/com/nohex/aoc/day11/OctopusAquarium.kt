package com.nohex.aoc.day11

/**
 * An aquarium filled with octopuses.
 * Each {@link ::step()} produces a new snapshot of life in the aquarium.
 */
class OctopusAquarium(private val octopuses: Set<Octopus>) {
    var flashCount: Int = 0
        private set
    private val flashers = mutableSetOf<Octopus>()

    fun step() {
        // Increase every octopus' energy level.
        octopuses.forEach { it.increaseLevel(flashers) }

        // Count the flashers.
        flashCount += flashers.size

        // All octopuses are free to flash again.
        flashers.clear()
    }
}
