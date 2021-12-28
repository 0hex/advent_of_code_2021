package com.nohex.aoc.day13

import com.nohex.aoc.PuzzleInput

fun main() {
    val input = getInput("input.txt")
    val mapData = MapData(input)
    val map = FoldingMap(mapData.dots.toMutableSet())
    val instructions = mapData.instructions.iterator()

    map.fold(instructions.next())
    println("Day 13, part 1: ${map.dotCount}")

    while (instructions.hasNext())
        map.fold(instructions.next())
    println("Day 13, part 2:")
    map.display()
}

fun getInput(path: String) =
    PuzzleInput(path).asSequence()
