package com.nohex.aoc.day7

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

internal class CrabAlignerTest : StringSpec({
    "fixed cost" {
        val sut = CrabAligner(loadPositions("example.txt"))
        sut.lowestFixedCost shouldBe 37
    }

    "variable cost" {
        val sut = CrabAligner(loadPositions("example.txt"))
        sut.lowestVariableCost shouldBe 168
    }
})
