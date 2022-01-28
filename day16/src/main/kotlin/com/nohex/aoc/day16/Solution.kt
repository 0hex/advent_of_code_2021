package com.nohex.aoc.day16

import com.nohex.aoc.PuzzleInput

fun main() {
    val inputIterator = getInput("input.txt")
        .toBCD()
        .iterator()
    val day1Solution = Packet.of(inputIterator).versions().sumOf { it }

    println("Day 16, part 1: $day1Solution")
}

fun getInput(path: String): Sequence<Char> =
    PuzzleInput(path)
        .asSequence()
        .flatMap { it.asSequence() }

