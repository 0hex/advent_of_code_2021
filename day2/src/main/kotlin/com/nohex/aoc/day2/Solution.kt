package com.nohex.aoc.day2

import com.nohex.aoc.PuzzleInput

fun main() {
    val submarine = Submarine()
    val instructions = getInput()
    instructions.forEach(submarine::move)
    println("Day2, part2: " + submarine.position)
}

private fun getInput() =
    PuzzleInput("input.txt")
        .asSequence()
        .filter(String::isNotBlank)
