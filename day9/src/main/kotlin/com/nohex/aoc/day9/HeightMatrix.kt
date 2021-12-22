package com.nohex.aoc.day9

import com.nohex.aoc.Point
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 * A matrix of height measurements.
 */
class HeightMatrix(input: Sequence<String>) {
    private val heights: Map<Point, Int>

    init {
        val matrix = mutableMapOf<Point, Int>()
        val iterator = input.iterator()
        var y = 0
        while (iterator.hasNext())
            matrix.addPoints(iterator.next(), y++)

        // Set the matrix.
        heights = matrix.toMap()
    }

    /**
     * Adds points to a mutable map, as defined in the given [encodedHeights].
     */
    private fun MutableMap<Point, Int>.addPoints(
        encodedHeights: String,
        y: Int
    ) {
        var x = 0
        for (value in encodedHeights) {
            // Get numeric value.
            val height = value - '0'
            this[Point(x, y)] = height
            x++
        }
    }

    /**
     * Gets the height at the point specified by [x] and [y].
     */
    fun at(x: Int, y: Int): Int? = heights[Point(x, y)]

    /**
     * Finds risk levels, i.e. the values that are the lowest among their neighbours,    plus one.
     */
    fun findRiskLevels(): Flow<Int> =
        flow {
            heights.forEach { (point, value) ->
                // The risk level is the low point value plus one.
                if (isLowPoint(point, value))
                    emit(value + 1)
            }
        }

    /**
     * Finds out whether the given point's value is the lowest among its neighbours.
     * The neighbours are the positions north, east, south and west of the current one.
     */
    private fun isLowPoint(point: Point, height: Int): Boolean {

        fun isLowerThan(deltaX: Int, deltaY: Int): Boolean =
            at(point.x + deltaX, point.y + deltaY).let {
                it == null || height < it
            }

        return isLowerThan(0, -1)
                && isLowerThan(1, 0)
                && isLowerThan(0, 1)
                && isLowerThan(-1, 0)
    }
}
