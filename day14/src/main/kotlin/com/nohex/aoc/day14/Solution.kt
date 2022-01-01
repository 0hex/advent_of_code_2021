package com.nohex.aoc.day14

import com.nohex.aoc.PuzzleInput

fun main() {
    val input = getInput("input.txt")
    val solution = with(InputParser(input)) {
        with(PolymerProcessor(template, insertionRules)) {
            repeat(10) { step() }
            counts.maxOf { it.value } - counts.minOf { it.value }
        }
    }

    println("Day 14, part 1: $solution")
}

fun getInput(path: String) =
    PuzzleInput(path).asSequence()
