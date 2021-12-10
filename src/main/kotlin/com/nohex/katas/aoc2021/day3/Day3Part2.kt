package com.nohex.katas.aoc2021.day3

import com.nohex.katas.Resources

fun main() {
    println("Life support rating: " + SubmarineMetrics().getLifeSupportRating(getInput()))
}

private fun getInput() =
    Resources.asLines("aoc2021/day3/input.txt")
        .filter(String::isNotBlank)

