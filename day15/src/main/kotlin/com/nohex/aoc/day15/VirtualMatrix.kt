package com.nohex.aoc.day15

import com.nohex.aoc.Matrix
import com.nohex.aoc.Point

/**
 *  A matrix whose contents can be expanded to the right and downward as
 *  replicas. The values in these replicas or tiles are increased as a factor
 *  of their distance to the original one.
 *
 *  A matrix with an expansion factor of 1 is just the original matrix.
 */
class VirtualMatrix(source: Sequence<String>, expansionFactor: Int = 1) : Matrix(source) {
    private val originalEnd: Point

    init {
        if (expansionFactor < 1)
            throw IllegalArgumentException("Expansion factor must be at least 1")

        originalEnd = end

        // Recalculate the end position with the expansion factor.
        end = Point(
            width * expansionFactor - 1,
            height * expansionFactor - 1
        )
    }

    /**
     * Get the value at [point]. If [point] is outside the original matrix,
     * calculate the value based on the expansion factor.
     */
    override operator fun get(point: Point): Int? {
        // If the coordinates are within the original matrix, use the parent method.
        if (point.x <= originalEnd.x && point.y <= originalEnd.y) {
            return super.get(point)
        }

        // If the coordinates are outside the map, return null.
        if (point.x !in 0..end.x || point.y !in 0..end.y) {
            return null
        }

        // Otherwise, calculate its value depending on the tile.
        // Find out which tile the point is in.
        val xTile = point.x / width
        val yTile = point.y / height

        // Where in the original map is this expanded location being replicated from.
        val replicatedLocation = Point(
            point.x.mod(width),
            point.y.mod(height)
        )

        return matrix[replicatedLocation]?.let {
            // Calculate the expanded value.
            (it + xTile + yTile - 1).mod(9) + 1
        }
    }
}