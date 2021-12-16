package com.nohex.aoc.day7

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class CrabAlignerTest {
    @Test
    fun testFixedCost() {
        val sut = CrabAligner(loadPositions("example.txt"))
        sut.lowestFixedCost shouldBe 37
    }

    @Test
    fun testVariableCost() {
        val sut = CrabAligner(loadPositions("example.txt"))
        sut.lowestVariableCost shouldBe 168
    }
}
