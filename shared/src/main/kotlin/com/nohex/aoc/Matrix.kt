package com.nohex.aoc

/**
 *  A 2-dimension array of single-digit numbers, created from a textual representation.
 */
open class Matrix(source: Sequence<String>) {
    var end: Point
        protected set

    protected val matrix: Map<Point, Int>
    protected val width: Int
    protected val height: Int

    init {
        matrix = source.mapIndexed { y, row ->
            row.mapIndexed { x, char ->
                Pair(Point(x, y), char.digitToInt())
            }
        }
            .flatMap { it }
            .map { it.first to it.second }
            .toMap()

        end = Point(
            matrix.maxOf { it.key.x },
            matrix.maxOf { it.key.y }
        )
        width = end.x + 1
        height = end.y + 1
    }

    /**
     * Get the value at [point].
     */
    open operator fun get(point: Point): Int? {
        // If the coordinates are outside the map, return null.
        if (point.x !in 0..end.x || point.y !in 0..end.y) {
            return null
        }

        return matrix[point]
    }

    override fun toString(): String = with(StringBuilder()) {
        for (y in 0 until height) {
            for (x in 0 until width)
                append(matrix[Point(x, y)])
            appendLine()
        }
        toString()
    }
}