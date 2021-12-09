package com.nohex.katas.aoc2021.day1

import com.nohex.katas.Resources

/**
 * Day 1 solution
 */

fun main() {
    println("Part 1: " + Solution().count(getInput()))
    println("Part 2: " + Solution().countWindows(getInput()))
}

private fun getInput() =
    Resources.asLines("aoc2021/day1/part1.txt")
        .filter(String::isNotBlank)
        .map(String::toInt)

