package com.nohex.katas.aoc2021.day4

/**
 * A game of bingo.
 */
class Game(private val boards: Set<Board>) {
    private var lastPlayedNumber: Int? = null
    var isOver = false
        private set

    /**
     * Play a sequence of number on the boards.
     * Once there is a winning board, stop playing.
     *
     * @param numbers The numbers to be played sequentially.
     */
    fun play(numbers: Sequence<Int>): Game {
        val playIterator = numbers.iterator()
        while (!isOver && playIterator.hasNext()) {
            play(playIterator.next())
        }

        return this
    }

    /**
     * Play a number on the boards in the bingo.
     * @param number The number to be played.
     */
    fun play(number: Int) {
        if (isOver)
            throw IllegalStateException("The game has finished")

        lastPlayedNumber = number
        isOver = boards.any { board -> board.check(number) }
    }

    fun getScore(): Int {
        if (lastPlayedNumber == null)
            throw IllegalStateException("No numbers have been played")

        if (!isOver)
            throw IllegalStateException("The game is not won yet")

        return boards.first(Board::isWinner).score * lastPlayedNumber!!
    }
}
