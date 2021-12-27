package com.nohex.aoc.day9

import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

/**
 * Methods to apply calculations to a set of height measurements.
 */
class MeasureCalculator(private val measures: Set<Measure>) {

    /**
     * Finds risk levels, i.e. the lowest points' heights, plus one.
     */
    fun findRiskLevels(): Flow<Int> =
        findLowPoints().transform { emit(it.height + 1) }

    /**
     * Finds risk levels, i.e. the values that are the lowest among their neighbours, plus one.
     * The
     */
    private fun findLowPoints(): Flow<Measure> = flow {
        measures
            .filter { isLowPoint(it) }
            .forEach { emit(it) }
    }

    /**
     * Finds out whether the given measurement's height is the lowest among its neighbours.
     */
    private fun isLowPoint(measure: Measure) = measure.neighbours
        .filterIsInstance<Measure>()
        .all { it.height > measure.height }

    /**
     * Multiplies the sizes of the three largest basins.
     */
    fun getTop3BasinSizeProduct(): Int = runBlocking {
        findLowPoints()
            .map { calculateBasinSize(it) }
            .toList()
            .sortedDescending()
            .take(3)
            .reduce { acc, i -> acc * i }
    }

    /**
     * For the given [measure], find all contiguous measures whose height is lower than 9.
     */
    private fun calculateBasinSize(measure: Measure): Int {
        val visited = mutableSetOf<Measure>()
        // Find neighbours whose height is lower than 9.
        return countNeighbours(visited, measure) { it.height < 9 }
    }


    /**
     * Recursively counts the [measure]'s neighbours that meet the [condition].
     */
    private fun countNeighbours(
        visited: MutableSet<Measure>, measure: Measure, condition: (Measure) -> Boolean
    ): Int {
        // If the condition is not fulfilled,
        // or the measure was already visited,
        // return nothing.
        if (!condition(measure) || (measure in visited)) return 0

        visited.add(measure)

        // Return all applicable neighbours plus the current measure.
        return measure.neighbours
            .filterIsInstance<Measure>()
            .sumOf { countNeighbours(visited, it, condition) } + 1
    }

}
