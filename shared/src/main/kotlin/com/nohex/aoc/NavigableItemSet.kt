package com.nohex.aoc

/**
 * Creates a map with elements that can navigate to their neighbours.
 *
 * The [relativeNeighbourPositions] establish the relative {@link Point}s
 * where the adjacent map elements can be found.
 *
 * @param T The type of the elements in the map.
 */
class NavigableItemSet<T : NavigableItem>(private val relativeNeighbourPositions: Set<Point>) {

    /**
     * Create a map from a sequence of strings (the [input]) that represent a
     * 2D chart. The function [elementBuilder] describes how a new element is
     * created from each character found in the [input].
     */
    fun load(
        input: Sequence<String>,
        elementBuilder: (Char) -> T
    ): Map<Point, T> {
        val cells = mutableMapOf<Point, T>()
        val iterator = input.iterator()
        var row = 0
        while (iterator.hasNext()) {
            var column = 0
            iterator.next().forEach { valueAsChar ->
                val newElement = elementBuilder(valueAsChar)
                cells.add(column++, row, newElement)
            }
            // Each line in the input is a new row.
            row++
        }

        return cells.toMap()
    }

    /**
     * Adds a value to a map indexed by {@link Point}s.
     */
    private fun MutableMap<Point, T>.add(
        column: Int,
        row: Int,
        newElement: T
    ) {
        val location = Point(column, row)

        // Add the new cell to the map.
        this[location] = newElement

        // Add neighbours.
        relativeNeighbourPositions.forEach {
            // If there is a cell at any of the specified map locations...
            this[location.transform(it)]
                // ... add them as neighbours.
                ?.let(newElement::addNeighbour)
        }
    }
}