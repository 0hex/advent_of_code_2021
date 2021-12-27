package com.nohex.aoc.day12

import com.nohex.aoc.PuzzleInput

fun main() {
    val caveMap = loadMap("input.txt")

    println("Day 12, part 1: ${caveMap.pathCount}")
    println("Day 12, part 2: ${caveMap.longPathCount}")
}

fun loadMap(path: String) =
    CaveMap(PuzzleInput(path).asSequence())

