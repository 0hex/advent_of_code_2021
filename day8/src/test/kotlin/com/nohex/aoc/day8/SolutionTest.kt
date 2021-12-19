package com.nohex.aoc.day8

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

internal class SolutionTest : StringSpec({
    "unique digit count" {
        getInput("example.txt")
            .let { getUniqueDigitCount(it) shouldBe 26 }
    }

    "digit sum" {
        getInput("example.txt")
            .let { getDigitSum(it) shouldBe 61229 }
    }
})
