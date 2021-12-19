package com.nohex.aoc.day8

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class SolutionTest {
    @Test
    fun testPart1() {
        val input = getInput("example.txt")
        getUniqueDigitCount(input) shouldBe 26
    }

    @Test
    fun testPart2() {
        val input = getInput("example.txt")
        getDigitSum(input) shouldBe 61229
    }
}
