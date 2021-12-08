package com.nohex.katas.aoc2021.day4

/**
 * Parses bingo files.
 */
class GameSettings(input: Sequence<String>) {
    val plays: Sequence<Int>
    val boards: Set<Board>

    init {
        val inputIterator = input.iterator()

        // The first line contains the numbers.
        plays = parsePlays(inputIterator.next())
        // The rest of the lines contain the boards.
        boards = parseBoards(inputIterator)
    }

    private fun parsePlays(playString: String): Sequence<Int> =
        playString.split(Regex(","))
            .filter(String::isNotBlank)
            .map { it.toInt() }
            .asSequence()

    private fun parseBoards(lineIterator: Iterator<String>): Set<Board> {
        val boards: MutableSet<Board> = mutableSetOf()
        var boardValues = mutableListOf<Int?>()
        while (lineIterator.hasNext()) {
            val line = lineIterator.next().trim()
            if (line.isNotBlank()) {
                boardValues += line.split(Regex("\\s+"))
                    .map { it.toInt() }
            } else if (boardValues.isNotEmpty()) {
                // Create new board.
                boards += Board(boardValues)
                // Reset the value string to receive new values.
                boardValues = mutableListOf()
            }
        }

        // Ensure no unprocessed lines were left.
        if (boardValues.isNotEmpty())
            boards += Board(boardValues)

        return boards
    }

}
