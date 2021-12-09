package com.nohex.katas.aoc2021.day4

/**
 * A game of bingo.
 */
class Game(private val boards: Set<Board>) {
    /**
     * Plays a sequence of numbers in a set of boards, and returns the first one to be completed.
     *
     * @see Board
     */
    fun getFirstCompletedBoard(plays: Sequence<Int>): Board? {
        var completedBoard: Board? = null
        val playIterator = plays.iterator()
        // Play until the first board is completed or the numbers run out.
        while (completedBoard == null && playIterator.hasNext())
            completedBoard = play(playIterator.next())

        return completedBoard
    }

    /**
     * Plays a sequence of numbers in a set of boards, and returns the last one to be completed.
     *
     * @see Board
     */
    fun getLastCompletedBoard(plays: Sequence<Int>): Board? {
        var lastCompletedBoard: Board? = null
        val playIterator = plays.iterator()
        // Play until there are no playable boards, or no plays left.
        while (boards.any { !it.isCompleted } && playIterator.hasNext())
            lastCompletedBoard = play(playIterator.next())

        return lastCompletedBoard
    }

    /**
     * Checks all the game's boards for the given number.
     * If one of the boards is completed, return it.
     * @param number The number to be played.
     */
    private fun play(number: Int): Board? =
        boards
            // Play only on boards that have not been yet completed.
            .filter { board -> !board.isCompleted }
            // Check the given number on all boards.
            .map { board -> board.check(number) }
            // If a board was completed, return it.
            .firstOrNull { board -> board.isCompleted }
}
