package com.nohex.katas.aoc2021.day5

import kotlin.math.abs

data class Point(val x: Int, val y: Int)

class Vector(private val start: Point, private val end: Point) {
    val isStraight = start.x == end.x || start.y == end.y
    val isDiagonal = abs(start.x - end.x) == abs(start.y - end.y)
    val points = if (isStraight) getStraightPoints() else getDiagonalPoints()

    private fun getStraightPoints(): Sequence<Point> =
        (start.x toward end.x).asSequence().flatMap { x ->
            (start.y toward end.y).map { y ->
                Point(x, y)
            }
        }

    private fun getDiagonalPoints(): Sequence<Point> {
        var y = start.y
        return (start.x toward end.x).asSequence().map { x ->
            Point(x, if (start.y < end.y) y++ else y--)
        }
    }

    private infix fun Int.toward(to: Int): IntProgression =
        IntProgression.fromClosedRange(this, to, if (this > to) -1 else 1)

    override fun toString(): String =
        "Vector (${start.x}, ${start.y} -> ${end.x}, ${end.y})"

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Vector) return false

        if (start != other.start) return false
        if (end != other.end) return false

        return true
    }

    override fun hashCode(): Int {
        var result = start.hashCode()
        result = 31 * result + end.hashCode()
        return result
    }
}
