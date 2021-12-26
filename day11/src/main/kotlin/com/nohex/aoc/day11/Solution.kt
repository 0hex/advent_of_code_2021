package com.nohex.aoc.day11

import com.nohex.aoc.PuzzleInput

fun main() {
    val input = getInput("input.txt")
    val octopuses = OctopusMapBuilder().load(input).values.toMutableSet()
    val aquarium = OctopusAquarium(octopuses)
    // Run for 100 iterations.
    repeat(100) { aquarium.step() }

    println("Day 11, part 1: ${aquarium.flashCount}")
}

fun getInput(path: String) =
    PuzzleInput(path).asSequence()
