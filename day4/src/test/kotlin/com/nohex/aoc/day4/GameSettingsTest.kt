package com.nohex.aoc.day4

import com.nohex.aoc.PuzzleInput
import io.kotest.matchers.collections.shouldContainInOrder
import io.kotest.matchers.sequences.shouldContainInOrder
import org.junit.jupiter.api.Test

internal class GameSettingsTest {
    @Test
    fun testParseSmallBoard() {
        val input = PuzzleInput("small.txt").asSequence()

        val sut = GameSettings(input)

        sut.plays shouldContainInOrder sequenceOf(3, 6, 9)
        sut.boards.toList()[0].values shouldContainInOrder listOf(
            1, 2, 3,
            4, 5, 6,
            7, 8, 9
        )
        sut.boards.toList()[1].values shouldContainInOrder listOf(
            3, 2, 1,
            4, 6, 8,
            7, 5, 9
        )
    }
}
