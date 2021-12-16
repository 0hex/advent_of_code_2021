package com.nohex.aoc.day8

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class SegmentGroupTest {
    @Test
    fun testEquality() {
        val sg1 = SegmentGroup("abcdefg")
        val sg2 = SegmentGroup("gfedcba")
        val sg3 = SegmentGroup("dafgebc")
        sg1 shouldBe sg2
        sg2 shouldBe sg3
        sg3 shouldBe sg1
    }
}
