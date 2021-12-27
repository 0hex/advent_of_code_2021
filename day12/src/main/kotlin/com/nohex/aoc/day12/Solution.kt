package com.nohex.aoc.day12

import com.nohex.aoc.PuzzleInput

fun main() {
    val pathCount = loadMap("input.txt").pathCount

    println("Day 12, part 1: $pathCount")
}

fun loadMap(path: String) =
    CaveMap(PuzzleInput(path).asSequence())

