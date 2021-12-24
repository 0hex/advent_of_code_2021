package com.nohex.aoc.day10

import com.nohex.aoc.PuzzleInput

fun main() {
    val input = getInput("input.txt")
    val analyser = ChunkAnalyser(input)

    println("Day 10, part 1: ${analyser.corruptedScore}")
    println("Day 10, part 2: ${analyser.middleScore}")
}

fun getInput(path: String) =
    PuzzleInput(path).asSequence()
