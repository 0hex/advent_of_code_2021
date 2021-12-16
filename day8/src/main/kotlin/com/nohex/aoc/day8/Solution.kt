package com.nohex.aoc.day8

import com.nohex.aoc.PuzzleInput

fun main() {
    val input = getInput("input.txt")
    val solution = DigitFinder(input).uniqueDigitCount

    println("day8, part 1: $solution")
}

fun getInput(path: String) =
    // Read the input.
    PuzzleInput(path)
        // Get each line.
        .asSequence()
        // Parse as digit information.
        .map { DigitData(it) }

