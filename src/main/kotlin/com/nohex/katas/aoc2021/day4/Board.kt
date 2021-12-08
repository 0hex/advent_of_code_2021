package com.nohex.katas.aoc2021.day4

/**
 * A bingo board.
 */
class Board(val values: MutableList<Int?>) {
    private val positionFinder: PositionFinder
    var isWinner = false
        private set
    var score: Int = 0
        private set
        get() = if (isWinner) values.filterNotNull().sum() else 0

    init {
        if (values.isEmpty())
            throw IllegalArgumentException("The board must have at least one cell")

        positionFinder = PositionFinder(values.size)
    }

    /**
     * Check whether the number is contained in the board.
     * If it is, the cell containing it will be marked.
     * If all cells in a row or a column are marked, the result will be true.
     * @return If the given number is contained in the last cell to be marked in a row or column.
     */
    fun check(number: Int): Boolean {
        val position: Int? = findPosition(number)
        if (position != null) {
            // Mark the position as played.
            markPosition(position)
            // If the row is all marked, the board is a winner.
            if (positionFinder.getRowIndexes(position).all(::isMarked))
                isWinner = true
            // If the column is all marked, the board is a winner.
            if (positionFinder.getColumnIndexes(position).all(::isMarked))
                isWinner = true
        }

        // Return whether it is a winning board.
        return isWinner
    }

    /**
     * If the board contains the given value, its position in the board is returned.
     */
    private fun findPosition(number: Int): Int? {
        val position = values.indexOf(number)
        return if (position == -1) null else position
    }

    /**
     * Marks a value as played.
     */
    private fun markPosition(position: Int) {
        values[position] = null
    }

    /**
     * Returns whether a position has been played.
     */
    private fun isMarked(position: Int) = values[position] == null
}
