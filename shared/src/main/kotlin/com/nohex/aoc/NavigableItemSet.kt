package com.nohex.aoc

/**
 * Creates a map with elements that can navigate to their neighbours.
 *
 * The [relativeNeighbourPositions] establish the relative {@link Point}s
 * where the adjacent map elements can be found.
 *
 * @param T The type of the elements in the map.
 */
class NavigableItemSet<T : NavigableItem>(
    private val relativeNeighbourPositions: Set<Point>,
    private val canTrackBack: Boolean = true
) {
    private val cells = mutableMapOf<Point, T>()

    /**
     * Create a map from a sequence of strings (the [input]) that represent a
     * 2D chart. The function [elementBuilder] describes how a new element is
     * created from each character found in the [input].
     */
    fun load(
        input: Sequence<String>,
        elementBuilder: (Point, Char) -> T
    ): Map<Point, T> {
        val iterator = input.iterator()

        // Set up the 2D map.
        var row = 0
        var column = 0
        while (iterator.hasNext()) {
            column = 0
            iterator.next().forEach { valueAsChar ->
                val position = Point(column++, row)
                val newElement = elementBuilder(position, valueAsChar)
                cells[position] = newElement
            }
            // Each line in the input is a new row.
            row++
        }

        // Once the map is complete, assign the neighbours.
        // This is done in two steps to ensure all neighbours are in place.
        for (x in 0 until column)
            for (y in 0 until row) {
                val location = Point(x, y)
                cells[location]?.let { origin ->
                    // Add neighbours.
                    relativeNeighbourPositions.forEach { currentLocation ->
                        // If there is a cell at any of the specified map locations...
                        cells[location.transform(currentLocation)]
                            // ... add them as neighbours.
                            ?.let { origin.addNeighbour(it, canTrackBack) }
                    }
                }
            }

        return cells.toMap()
    }
}