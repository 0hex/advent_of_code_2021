package com.nohex.aoc.day11

/**
 * An aquarium filled with octopuses.
 * Each {@link ::step()} produces a new snapshot of life in the aquarium.
 */
class OctopusAquarium(private val octopuses: Set<Octopus>) {
    var flashCount: Int = 0
        private set
    var iteration = 0
        private set
    val allFlashed
        get() = flashers.size == octopuses.size
    private val flashers = mutableSetOf<Octopus>()

    fun step() {
        iteration++

        // All octopuses are now free to flash.
        flashers.clear()

        // Increase every octopus' energy level.
        octopuses.forEach { it.increaseLevel(flashers) }

        // Keep track of the flashes.
        flashCount += flashers.size
    }
}
