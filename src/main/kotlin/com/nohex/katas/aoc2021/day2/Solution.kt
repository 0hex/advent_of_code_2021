package com.nohex.katas.aoc2021.day2

import com.nohex.katas.Resources

/**
 * Day 2 solution
 */

fun main() {
    println("Part 1: " + Solution().getPosition(getInput()))
}

private fun getInput() =
    Resources.asLines("aoc2021/day2/part1.txt")
        .filter(String::isNotBlank)

internal class Solution {

    fun getPosition(moves: Sequence<String>): Pair<Int, Int> {
        var x = 0
        var depth = 0
        for (move in moves) {
            val (direction, distanceString, _) = move.split(" ")
            val distance = distanceString.toInt()
            when (direction) {
                "forward" -> x += distance
                "down" -> depth += distance
                "up" -> depth -= distance
            }
        }

        return Pair(x, depth)
    }
}
