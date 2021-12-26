package com.nohex.aoc.day11

import com.nohex.aoc.Point

/**
 * Creates a map of octopuses.
 */
class OctopusMapBuilder {
    fun load(input: Sequence<String>): Map<Point, Octopus> {
        val cells = mutableMapOf<Point, Octopus>()
        val iterator = input.iterator()
        var y = 0
        while (iterator.hasNext())
            cells.addCells(iterator.next(), y++)

        return cells.toMap()
    }

    /**
     * Adds values to a map of {@link Point}s and {@link Octopus}es from the characters in [encodedValues].
     */
    private fun MutableMap<Point, Octopus>.addCells(
        encodedValues: String,
        y: Int
    ) {
        var x = 0
        encodedValues.forEach { valueAsChar ->
            // Get numeric value.
            val numericValue = valueAsChar - '0'
            this.add(x, y, Octopus(numericValue))
            x++
        }
    }

    /**
     * Adds a value to a map of {@link Point}s and {@link Octopus}es.
     */
    private fun MutableMap<Point, Octopus>.add(
        x: Int,
        y: Int,
        newOctopus: Octopus
    ) {
        val location = Point(x, y)

        // Add the new cell to the map.
        this[location] = newOctopus

        // Add neighbours.
        (-1..1).forEach { deltaX ->
            (-1..1).forEach { deltaY ->
                // Skip the new cell location.
                if (!(deltaX == 0 && deltaY == 0))
                // If there is a cell at any of the specified map locations...
                    this[Point(x + deltaX, y + deltaY)]
                        // ... add them as neighbours.
                        ?.let(newOctopus::addNeighbour)
            }
        }
    }
}