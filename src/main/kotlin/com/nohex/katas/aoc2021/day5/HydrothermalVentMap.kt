package com.nohex.katas.aoc2021.day5

import kotlin.math.max
import kotlin.math.min

class HydrothermalVentMap(vectors: Sequence<Vector>) {

    private val countsPerPoint = mutableMapOf<Point, Int>()

    init {
        // Parse vectors into points.
        vectors.flatMap(::getVectorPoints)
            .forEach { point -> countsPerPoint.merge(point, 1, Int::plus) }
    }

    /**
     * Gets all the [Point]s in a [vector].
     */
    private fun getVectorPoints(vector: Vector): Sequence<Point> {
        // Set up the ranges to always have a positive step.
        val fromX = min(vector.startX, vector.endX)
        val toX = max(vector.startX, vector.endX)
        val fromY = min(vector.startY, vector.endY)
        val toY = max(vector.startY, vector.endY)
        return (fromX..toX).asSequence().flatMap { x ->
            (fromY..toY).map { y ->
                Point(x, y)
            }
        }
    }


    /**
     * Returns the number of points where the number of crossing lines is equal or above the [threshold].
     */
    fun getOverlapCount(threshold: Int): Int =
        countsPerPoint.filter { it.value >= threshold }.count()


    fun printMap(width: Int, height: Int) {
        (0 until height).forEach { y ->
            (0 until width).forEach { x ->
                val point = Point(x, y)
                val symbol = countsPerPoint[point]?.toString() ?: "."
                print(symbol)
            }
            println()
        }
    }
}

data class Point(val x: Int, val y: Int)

data class Vector(val startX: Int, val startY: Int, val endX: Int, val endY: Int)
