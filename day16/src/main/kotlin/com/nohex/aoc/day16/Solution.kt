package com.nohex.aoc.day16

import com.nohex.aoc.PuzzleInput

fun main() {
    val inputIterator = getInput("input.txt")
        .toBinary()
        .iterator()
    val packet = Packet.of(inputIterator)
    val day1Solution = packet.versions().sumOf { it }
    val day2Solution = packet.value()

    println("Day 16, part 1: $day1Solution")
    println("Day 16, part 2: $day2Solution")
}

fun getInput(path: String): Sequence<Char> =
    PuzzleInput(path)
        .asSequence()
        .flatMap { it.asSequence() }

