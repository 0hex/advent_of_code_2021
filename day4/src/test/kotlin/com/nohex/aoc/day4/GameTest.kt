package com.nohex.aoc.day4

import com.nohex.aoc.PuzzleInput
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

internal class GameTest : StringSpec({
    "example" {
        val settings = PuzzleInput("example.txt").asSequence()
        GameSettings(settings).run {
            Game(boards).getFirstCompletedBoard(plays)?.score shouldBe 4512
        }
    }

    "small example" {
        val settings = PuzzleInput("small.txt").asSequence()
        GameSettings(settings).run {
            Game(boards).getFirstCompletedBoard(plays)?.score shouldBe 243
        }
    }

    "last board" {
        val settings = PuzzleInput("example.txt").asSequence()
        GameSettings(settings).run {
            Game(boards).getLastCompletedBoard(plays)?.score shouldBe 1924
        }
    }
})
