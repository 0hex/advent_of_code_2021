package com.nohex.aoc.day8

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class DigitTest {
    @Test
    fun testEquality() {
        val sg1 = Digit("abcdefg")
        val sg2 = Digit("gfedcba")
        val sg3 = Digit("dafgebc")
        sg1 shouldBe sg2
        sg2 shouldBe sg3
        sg3 shouldBe sg1
    }

    @Test
    fun testMinus() {
        val sg1 = Digit("abc")
        val sg2 = Digit("ab")

        sg1 minus sg2 shouldBe charArrayOf('c')
    }

    @Test
    fun testMinusNoEffect() {
        val sg1 = Digit("abc")
        val sg2 = Digit("de")

        sg1 minus sg2 shouldBe sg1.segments
    }

    @Test
    fun testContainsAll() {
        val sg1 = Digit("abc")
        val sg2 = Digit("ab")

        sg1.contains(sg2) shouldBe true
    }
}
