package com.nohex.aoc.day9

import com.nohex.aoc.PuzzleInput
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val input = getInput("input.txt")
    val measureSet = MeasureSet(input)

    val riskLevelSum = measureSet
        .findRiskLevels()
        .toList().sum()
    println("Day 9, part 1: $riskLevelSum")

    val largest3BasinsSizeProduct = measureSet.getTop3BasinSizeProduct()
    println("Day 9, part 2: $largest3BasinsSizeProduct")
}

fun getInput(path: String) =
    PuzzleInput(path).asSequence()
