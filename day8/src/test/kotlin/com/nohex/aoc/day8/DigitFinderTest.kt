package com.nohex.aoc.day8

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class DigitFinderTest {
    @Test
    fun testExample() {
        val input = getInput("example.txt")
        val sut = DigitFinder(input)
        sut.uniqueDigitCount shouldBe 26
    }
}
