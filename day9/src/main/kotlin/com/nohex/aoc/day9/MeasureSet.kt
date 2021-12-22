package com.nohex.aoc.day9

import com.nohex.aoc.Point
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.transform

val neighbourRelativePositions = setOf(
    Point(0, -1), // North
    Point(1, 0), // West
    Point(-1, 0),// East
    Point(0, 1) // South
)

/**
 * A collection of height measurements.
 */
class MeasureSet(input: Sequence<String>) {
    private val measures: Set<Measure>

    init {
        val measureMap = mutableMapOf<Point, Measure>()
        val iterator = input.iterator()
        var y = 0
        while (iterator.hasNext())
            measureMap.addHeights(iterator.next(), y++)

        measures = measureMap.values.toSet()
    }

    /**
     * Adds measurements to a mutable map, as defined in the given [encodedHeights].
     */
    private fun MutableMap<Point, Measure>.addHeights(
        encodedHeights: String,
        y: Int
    ) {
        var x = 0
        for (value in encodedHeights) {
            // Get numeric value.
            val height = value - '0'
            this.add(x, y, height)
            x++
        }
    }

    /**
     * Adds a measurement to a mutable map.
     */
    private fun MutableMap<Point, Measure>.add(
        x: Int,
        y: Int,
        height: Int
    ) {
        val location = Point(x, y)
        val measure = Measure(height)

        neighbourRelativePositions
            // Transform to actual map locations based on the current one.
            .map { Point(location.x + it.x, location.y + it.y) }
            // If there is a measure in that location...
            .mapNotNull { this[it] }
            // ... add it as a neighbour.
            .forEach(measure::addNeighbour)

        // Add the new measure to the map.
        this[location] = measure
    }

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
    private fun isLowPoint(measure: Measure) =
        measure.neighbours.all { it.height > measure.height }
}
