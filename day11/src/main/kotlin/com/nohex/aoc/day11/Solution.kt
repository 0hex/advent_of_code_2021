package com.nohex.aoc.day11

import com.nohex.aoc.NavigableItemSet
import com.nohex.aoc.Point
import com.nohex.aoc.PuzzleInput

val allCardinalPoints = setOf(
    Point(-1, -1), // NW
    Point(0, -1), // N
    Point(1, -1), // NE
    Point(-1, 0), // W
    Point(1, 0), // E
    Point(-1, 1), // SW
    Point(0, 1), // S
    Point(1, 1), // SE
)

fun main() {
    val octopuses = spawnOctopuses("input.txt")
    val aquarium = OctopusAquarium(octopuses)
    var hundredthIterationFlashCount: Int? = null
    var firstFullFlashIterationStep: Int? = null

    // Iterate until both measures have been found.
    while (hundredthIterationFlashCount == null || firstFullFlashIterationStep == null) {
        aquarium.step()

        if (aquarium.iteration == 100) {
            hundredthIterationFlashCount = aquarium.flashCount
        }

        if (aquarium.allFlashed) {
            firstFullFlashIterationStep = aquarium.iteration
        }
    }

    println("Day 11, part 1: $hundredthIterationFlashCount")
    println("Day 11, part 2: $firstFullFlashIterationStep")
}

fun spawnOctopuses(path: String): MutableSet<Octopus> {
    val input = PuzzleInput(path).asSequence()
    val octopuses = NavigableItemSet<Octopus>(allCardinalPoints)
        .load(input) { Octopus(it - '0') }
        .values.toMutableSet()
    return octopuses
}