package com.nohex.aoc.day9

import com.nohex.aoc.NavigableItemSet
import com.nohex.aoc.Point
import com.nohex.aoc.PuzzleInput
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking


val mainCardinalPoints = setOf(
    Point(0, -1), // North
    Point(1, 0), // West
    Point(-1, 0),// East
    Point(0, 1) // South
)

fun main() = runBlocking {
    val measureCalculator = MeasureCalculator(loadMeasures("input.txt"))

    val riskLevelSum = measureCalculator
        .findRiskLevels()
        .toList().sum()
    println("Day 9, part 1: $riskLevelSum")

    val largest3BasinsSizeProduct = measureCalculator.getTop3BasinSizeProduct()
    println("Day 9, part 2: $largest3BasinsSizeProduct")
}

fun loadMeasures(path: String) =
    PuzzleInput(path).asSequence().let { data ->
        NavigableItemSet<Measure>(mainCardinalPoints)
            .load(data) { Measure(it - '0') }
            .values.toSet()
    }
