package com.nohex.katas.aoc2021.day4

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class PositionFinderTest {
    @Test
    fun failOnNonSquareBoards() {
        (5..8).forEach {
            shouldThrow<IllegalArgumentException> { PositionFinder(it) }
        }
    }

    @Test
    fun test2x2Board() {
        val sut = PositionFinder(4)
        sut.getRowIndexes(0) shouldBe 0..1
        sut.getColumnIndexes(0) shouldBe (0..2 step 2)

        sut.getRowIndexes(1) shouldBe 0..1
        sut.getColumnIndexes(1) shouldBe (1..3 step 2)

        sut.getRowIndexes(2) shouldBe 2..3
        sut.getColumnIndexes(2) shouldBe (0..2 step 2)

        sut.getRowIndexes(3) shouldBe 2..3
        sut.getColumnIndexes(3) shouldBe (1..3 step 2)
    }

    @Test
    fun test10x10Board() {
        val sut = PositionFinder(100)

        sut.getColumnIndexes(3) shouldBe (3..93 step 10)
        sut.getRowIndexes(3) shouldBe (0..9)

        sut.getColumnIndexes(25) shouldBe (5..95 step 10)
        sut.getRowIndexes(25) shouldBe (20..29)
    }

    @Test
    fun testLargeBoard() {
        val sideLength = 1024
        val boardSize = sideLength * sideLength
        val sut = PositionFinder(boardSize)

        sut.getColumnIndexes(boardSize - 1) shouldBe (sideLength - 1 until boardSize step sideLength)
        sut.getRowIndexes(boardSize - 1) shouldBe (boardSize - sideLength until boardSize)
    }

    @Test
    fun testOffLimits() {
        val sut = PositionFinder(1)
        shouldThrow<IndexOutOfBoundsException> { sut.getColumnIndexes(1) }
        shouldThrow<IndexOutOfBoundsException> { sut.getRowIndexes(1) }
    }
}
