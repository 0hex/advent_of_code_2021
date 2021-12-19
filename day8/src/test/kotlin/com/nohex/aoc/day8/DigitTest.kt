package com.nohex.aoc.day8

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

internal class DigitTest : StringSpec({
    "digits with the same segments are equal, despite their order" {
        val sg1 = Digit("abcdefg")
        val sg2 = Digit("gfedcba")
        val sg3 = Digit("dafgebc")
        sg1 shouldBe sg2
        sg2 shouldBe sg3
        sg3 shouldBe sg1
    }

    "minus" {
        val sg1 = Digit("abc")
        val sg2 = Digit("ab")

        sg1 minus sg2 shouldBe charArrayOf('c')
    }

    "minus with non-intersecting segment group has no effect" {
        val sg1 = Digit("abc")
        val sg2 = Digit("de")

        sg1 minus sg2 shouldBe sg1.segments
    }

    "contains" {
        val sg1 = Digit("abc")
        val sg2 = Digit("ab")

        sg1.contains(sg2) shouldBe true
    }
})
