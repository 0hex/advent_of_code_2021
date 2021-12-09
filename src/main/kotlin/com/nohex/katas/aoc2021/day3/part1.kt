package com.nohex.katas.aoc2021.day3

import com.nohex.katas.Resources

/**
 * Day 2 solution
 */

fun main() {
    println("Power consumption: " + SubmarineMetrics().getPowerConsumption(getInput()))
}

private fun getInput() =
    Resources.asLines("aoc2021/day3/input.txt")
        .filter(String::isNotBlank)
