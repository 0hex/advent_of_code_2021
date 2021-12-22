package com.nohex.aoc.day9

import com.nohex.aoc.PuzzleInput
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val input = getInput("input.txt")
    val solution = HeightMatrix(input)
        .findRiskLevels()
        .toList().sum()

    println("day9, part 1: $solution")
}

fun getInput(path: String) =
    PuzzleInput(path).asSequence()
