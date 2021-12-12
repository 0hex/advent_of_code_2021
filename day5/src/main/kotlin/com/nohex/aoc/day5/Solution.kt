package com.nohex.aoc.day5

import com.nohex.aoc.PuzzleInput

fun main() {
    // Count only the vectors that define straight lines.
    val straightVectors = loadVectors().filter { it.isStraight }
    val straightCount = HydrothermalVentMap(straightVectors)
        .getOverlapCount(threshold = 2)
    println("Day 5, part 1: $straightCount")

    // Count only the vectors that define either diagonal or straight lines.
    val straightAndDiagonalVectors = loadVectors().filter { it.isStraight || it.isDiagonal }
    val straightAndDiagonalCount = HydrothermalVentMap(straightAndDiagonalVectors)
        .getOverlapCount(threshold = 2)
    println("Day 5, part 2: $straightAndDiagonalCount")
}

private fun loadVectors() =
    VectorReader(PuzzleInput("input.txt").asSequence()).vectors
