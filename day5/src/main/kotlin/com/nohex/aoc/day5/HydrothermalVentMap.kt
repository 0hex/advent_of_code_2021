package com.nohex.aoc.day5

import com.nohex.aoc.Point

class HydrothermalVentMap(vectors: Sequence<Vector>) {

    private val countsPerPoint = mutableMapOf<Point, Int>()

    init {
        vectors.flatMap { it.points }
            .forEach { point -> countsPerPoint.merge(point, 1, Int::plus) }
    }

    /**
     * Returns the number of points where the number of crossing lines is equal or above the [threshold].
     */
    fun getOverlapCount(threshold: Int): Int =
        countsPerPoint.filter { it.value >= threshold }.count()
}
