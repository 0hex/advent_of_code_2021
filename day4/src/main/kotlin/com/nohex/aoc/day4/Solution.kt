package com.nohex.aoc.day4

import com.nohex.aoc.PuzzleInput

fun main() {
    val settings = PuzzleInput("input.txt").asSequence()

    GameSettings(settings).run {
        val firstCompletedBoardScore = Game(boards).getFirstCompletedBoard(plays)?.score
        println("Day 4, part 1: $firstCompletedBoardScore")
        val lastCompletedBoardScore = Game(boards).getLastCompletedBoard(plays)?.score
        println("Day 4, part 2: $lastCompletedBoardScore")
    }
}
