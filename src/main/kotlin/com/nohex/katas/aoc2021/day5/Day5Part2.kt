package com.nohex.katas.aoc2021.day5

import com.nohex.katas.Resources

fun main() {
    val readings = Resources.asLines("aoc2021/day5/input.txt")
    val vectors = VectorReader(readings).vectors
        // Keep only the vectors that define either straight or diagonal lines.
        .filter { it.isStraight || it.isDiagonal }

    println(HydrothermalVentMap(vectors).getOverlapCount(threshold = 2))
}
