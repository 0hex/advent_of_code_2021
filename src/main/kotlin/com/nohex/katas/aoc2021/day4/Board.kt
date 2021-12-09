package com.nohex.katas.aoc2021.day4

/**
 * A bingo board.
 */
class Board(val values: MutableList<Int?>) {
    val isCompleted: Boolean
        get() = score != null
    var score: Int? = null
        private set

    private val positionFinder: PositionFinder

    init {
        if (values.isEmpty())
            throw IllegalArgumentException("The board must have at least one cell")

        positionFinder = PositionFinder(values.size)
    }

    /**
     * Check whether the number is contained in the board.
     * If it is, the cell containing it will be marked.
     * If all cells in a row or a column are marked, the board is completed.
     * @return The board, for call chaining.
     * @throws IllegalStateException If the board is already completed.
     */
    fun check(number: Int): Board {
        if (isCompleted)
            throw IllegalStateException("The board is already completed")

        findPosition(number)?.let {
            // Mark the position as played.
            markPosition(it)
            // The board is completed when either the number's row or column are all marked.
            if (
                positionFinder.getRowIndexes(it).all(::isMarked)
                || positionFinder.getColumnIndexes(it).all(::isMarked)
            ) {
                // When the board is completed, calculate the score.
                score = values.filterNotNull().sum() * number
            }
        }

        return this
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
