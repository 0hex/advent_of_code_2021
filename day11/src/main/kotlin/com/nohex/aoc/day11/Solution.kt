package com.nohex.aoc.day11

import com.nohex.aoc.PuzzleInput

fun main() {
    val input = getInput("input.txt")
    val octopuses = OctopusMapBuilder().load(input).values.toMutableSet()
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

fun getInput(path: String) =
    PuzzleInput(path).asSequence()
