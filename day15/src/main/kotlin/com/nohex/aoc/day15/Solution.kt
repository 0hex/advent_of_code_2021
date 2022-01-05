package com.nohex.aoc.day15

import com.nohex.aoc.Matrix
import com.nohex.aoc.PuzzleInput

fun main() {
    val map = Matrix(getInput("input.txt"))
    val part1 = PathComputer(map).lowestRisk

    val tiledMap = VirtualMatrix(getInput("input.txt"), expansionFactor = 5)
    val part2 = PathComputer(tiledMap).lowestRisk

    println("Day 15, part 1: $part1")
    println("Day 15, part 2: $part2")
}

fun getInput(path: String) = PuzzleInput(path).asSequence()