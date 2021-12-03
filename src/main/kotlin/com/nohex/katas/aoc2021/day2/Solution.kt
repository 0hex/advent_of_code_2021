package com.nohex.katas.aoc2021.day2

import com.nohex.katas.Resources

/**
 * Day 2 solution
 */

fun main() {
    println("Position: " + Solution().getPosition(getInput()))
}

private fun getInput() =
    Resources.asLines("aoc2021/day2/input.txt")
        .filter(String::isNotBlank)

internal class Solution {

    fun getPosition(moves: Sequence<String>): Pair<Int, Int> {
        var x = 0
        var depth = 0
        var aim = 0
        for (move in moves) {
            val (direction, unitsString, _) = move.split(" ")
            val units = unitsString.toInt()
            when (direction) {
                "forward" -> {x += units; depth += aim * units}
                "down" -> aim += units
                "up" -> aim -= units
            }
        }

        return Pair(x, depth)
    }
}
