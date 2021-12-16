package com.nohex.aoc.day7

import com.nohex.aoc.PuzzleInput

fun main() {
    val crabAligner = CrabAligner(loadPositions("input.txt"))
    println("Day 7, part 1: " + crabAligner.lowestCost)
}

fun loadPositions(path: String): Sequence<Int> = PuzzleInput(path)
    .asString()
    .splitToSequence(",")
    .map(String::trim)
    .map { it.toInt() }
