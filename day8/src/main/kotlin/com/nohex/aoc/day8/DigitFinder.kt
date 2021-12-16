package com.nohex.aoc.day8

class DigitFinder(input: Sequence<DigitData>) {
    val uniqueDigitCount = input
        .flatMap { it.digits }
        // Count if the segments match those for:
        // 1 -> 2 segments
        // 4 -> 4 segments
        // 7 -> 3 segments
        // 8 -> 7 segments
        .count { val i = it.segments; i == 2 || i == 3 || i == 4 || i == 7 }
}
