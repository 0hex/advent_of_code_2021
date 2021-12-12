package com.nohex.aoc.day2

internal class Submarine {
    private var x = 0
    private var depth = 0
    private var aim = 0

    val position get() = Pair(x, depth)

    fun move(instruction: String) {
        val (direction, unitsString, _) = instruction.split(" ")
        val units = unitsString.toInt()
        when (direction) {
            "forward" -> {
                x += units
                depth += aim * units
            }
            "down" -> aim += units
            "up" -> aim -= units
        }
    }
}
