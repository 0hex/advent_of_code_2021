package com.nohex.aoc.day4

import com.nohex.aoc.PuzzleInput
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class GameTest {
    @Test
    fun testExample() {
        val settings = PuzzleInput("example.txt").asSequence()
        GameSettings(settings).run {
            Game(boards).getFirstCompletedBoard(plays)?.score shouldBe 4512
        }
    }

    @Test
    fun testSmallExample() {
        val settings = PuzzleInput("small.txt").asSequence()
        GameSettings(settings).run {
            Game(boards).getFirstCompletedBoard(plays)?.score shouldBe 243
        }
    }

    @Test
    fun testLastBoard() {
        val settings = PuzzleInput("example.txt").asSequence()
        GameSettings(settings).run {
            Game(boards).getLastCompletedBoard(plays)?.score shouldBe 1924
        }
    }
}
