package com.nohex.aoc.day8

class DigitData(input: String) {
    val digits: List<SegmentGroup>

    init {
        val (_, digitData) = input.split(" | ")
        digits = digitData
            .split(" ")
            .map { SegmentGroup(it) }
    }
}
