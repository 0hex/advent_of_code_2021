package com.nohex.aoc.day9

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.flow.toList

internal class HeightMatrixTest : ShouldSpec({
    context("The example input") {
        val input = getInput("example.txt")
        val sut = HeightMatrix(input)

        should("have 2 in its top left corner") {
            sut.at(0, 0) shouldBe 2
        }

        should("have 8 in its bottom right corner") {
            sut.at(9, 4) shouldBe 8
        }

        should("produce the expected result") {
            val riskLevels = sut.findRiskLevels().toList()
            riskLevels.sum() shouldBe 15
        }
    }
})
