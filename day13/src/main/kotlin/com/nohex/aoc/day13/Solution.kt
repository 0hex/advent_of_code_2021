package com.nohex.aoc.day13

import com.nohex.aoc.PuzzleInput

fun main() {
    val input = getInput("input.txt")
    val mapData = MapData(input)
    val map = FoldingMap(mapData.dots.toMutableSet())
    map.fold(mapData.instructions.first())

    println("Day 13, part 1: ${map.dotCount}")
}

fun getInput(path: String) =
    PuzzleInput(path).asSequence()
