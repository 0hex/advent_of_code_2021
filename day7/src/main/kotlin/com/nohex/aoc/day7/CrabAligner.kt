package com.nohex.aoc.day7

import kotlin.math.abs

class CrabAligner(input: Sequence<Int>) {
    private val values = input.toList().sorted()

    val lowestCost =
        values.minOfOrNull { value -> cost(value) }

    private fun cost(value: Int) =
        values.sumOf { abs(value - it) }
}
