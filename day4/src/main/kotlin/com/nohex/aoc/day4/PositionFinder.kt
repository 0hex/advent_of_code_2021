package com.nohex.aoc.day4

import kotlin.math.sqrt
import kotlin.math.truncate

/**
 * Calculates the indexes of both rows and columns for a given position in a board.
 */
class PositionFinder(private var boardSize: Int) {
    private val sideLength: Int

    init {
        val calculatedSideLength = sqrt(boardSize.toDouble())
        sideLength = truncate(calculatedSideLength).toInt()
        if (calculatedSideLength != sideLength.toDouble())
            throw IllegalArgumentException("The board does not have a square layout")
    }

    fun getRowIndexes(index: Int): IntProgression {
        if (index > boardSize - 1)
            throw IndexOutOfBoundsException("Position $index is out of the board ($boardSize)")

        // Multiply by integer part of division result.
        val rowStart = (index / sideLength) * sideLength
        val rowEnd = rowStart + sideLength - 1

        return rowStart..rowEnd
    }

    fun getColumnIndexes(index: Int): IntProgression {
        if (index > boardSize - 1)
            throw IndexOutOfBoundsException("Position $index is out of the board ($boardSize)")

        // Find out the position where the column starts.
        val row: Int = index / sideLength
        val columnStart = index - (row * sideLength)
        // Find out the position where the column ends.
        val columnEnd = boardSize - sideLength + columnStart

        return columnStart..columnEnd step sideLength
    }
}
