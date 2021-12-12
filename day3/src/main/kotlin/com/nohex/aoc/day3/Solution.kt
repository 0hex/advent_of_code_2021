package com.nohex.aoc.day3

import com.nohex.aoc.PuzzleInput

fun main() {
    val submarineMetrics = SubmarineMetrics()
    println("Day 3, part 1: " + submarineMetrics.getPowerConsumption(getInput()))
    println("Day 3, part 2: " + submarineMetrics.getPowerConsumption(getInput()))
}

private fun getInput() =
    PuzzleInput("input.txt").asSequence()
        .filter(String::isNotBlank)
