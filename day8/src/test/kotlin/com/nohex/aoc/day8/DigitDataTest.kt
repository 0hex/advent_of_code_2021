package com.nohex.aoc.day8

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

private const val inputForDigitData =
    "acedgfb cdfbe gcdfa fbcad dab cefabd cdfgeb eafb cagedb ab | cdfeb fcadb cdfeb cdbaf"

internal class DigitDataTest {
    @Test
    fun testInferWiring() {
        val sut = DigitData(inputForDigitData)
        sut.wiring[0]!! shouldBe Digit("cagedb")
        sut.wiring[1]!! shouldBe Digit("ab")
        sut.wiring[2]!! shouldBe Digit("gcdfa")
        sut.wiring[3]!! shouldBe Digit("fbcad")
        sut.wiring[4]!! shouldBe Digit("eafb")
        sut.wiring[5]!! shouldBe Digit("cdfbe")
        sut.wiring[6]!! shouldBe Digit("cdfgeb")
        sut.wiring[7]!! shouldBe Digit("dab")
        sut.wiring[8]!! shouldBe Digit("acedgfb")
        sut.wiring[9]!! shouldBe Digit("cefabd")
    }
}