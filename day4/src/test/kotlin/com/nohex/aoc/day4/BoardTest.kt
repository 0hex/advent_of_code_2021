package com.nohex.aoc.day4

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class BoardTest {
    private val values = listOf(
        22, 13, 17, 11, 0,
        8, 2, 23, 4, 24,
        21, 9, 14, 16, 7,
        6, 10, 3, 18, 5,
        1, 12, 20, 15, 19
    )

    @Test
    fun failOnNonSquareValueList() {
        shouldThrow<IllegalArgumentException> { Board((1..5).toMutableList()) }
    }

    @Test
    fun testWinningRow() {
        val sut = Board(values.toMutableList())
        for (i in listOf(22, 13, 17, 11))
            sut.check(i).isCompleted shouldBe false

        sut.check(0).isCompleted shouldBe true
    }

    @Test
    fun testWinningColumn() {
        val sut = Board(values.toMutableList())
        for (i in listOf(22, 8, 21, 6))
            sut.check(i).isCompleted shouldBe false

        sut.check(1).isCompleted shouldBe true
    }
}
