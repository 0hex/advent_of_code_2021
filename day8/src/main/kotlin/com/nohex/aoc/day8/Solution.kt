package com.nohex.aoc.day8

import com.nohex.aoc.PuzzleInput

fun main() {
    val uniqueDigitCount = getUniqueDigitCount(getInput("input.txt"))
    println("day8, part 1: $uniqueDigitCount")

    val allDigitSum = getDigitSum(getInput("input.txt"))
    println("day8, part 2: $allDigitSum")
}

fun getInput(path: String) =
    // Read the input.
    PuzzleInput(path)
        // Get each line.
        .asSequence()

fun getUniqueDigitCount(entries: Sequence<String>) =
    entries
        // Parse as digit information.
        .map { DigitData(it) }
        .flatMap { it.digits }
        // Count if the segments match those for:
        // 1 -> 2 segments
        // 4 -> 4 segments
        // 7 -> 3 segments
        // 8 -> 7 segments
        .count { it.segmentCount in arrayOf(2, 3, 4, 7) }

fun getDigitSum(entries: Sequence<String>) =
    entries
        .map { DigitData(it) }
        .sumOf { it.decodedNumber }