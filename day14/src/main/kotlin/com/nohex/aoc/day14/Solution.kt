package com.nohex.aoc.day14

import com.nohex.aoc.PuzzleInput

fun main() {
    val input = getInput("input.txt")
    val polymerProcessor = with(InputParser(input)) {
        PolymerProcessor(template, insertionRules)
    }
    val part1Solution = with(polymerProcessor) {
        repeat(10) { step() }
        elementCounts.maxOf { it.value } - elementCounts.minOf { it.value }
    }
    val part2Solution = with(polymerProcessor) {
        repeat(30) { step() }
        elementCounts.maxOf { it.value } - elementCounts.minOf { it.value }
    }

    println("Day 14, part 1: $part1Solution")
    println("Day 14, part 2: $part2Solution")
}

fun getInput(path: String) =
    PuzzleInput(path).asSequence()
