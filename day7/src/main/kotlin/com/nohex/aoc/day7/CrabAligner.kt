package com.nohex.aoc.day7

import kotlin.math.abs

class CrabAligner(input: Sequence<Int>) {
    private val values = input.toList().sorted()

    val lowestFixedCost =
        values.minOfOrNull { value -> fixedCost(value) }

    val lowestVariableCost =
        (values.first()..values.last())
            .minOfOrNull { value -> variableCost(value) }

    private fun fixedCost(value: Int): Int {
        return values.sumOf { abs(value - it) }
    }

    private fun variableCost(value: Int) =
        values.sumOf { val n = abs(it - value); (n * (n + 1)) / 2 }
}
