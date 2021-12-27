package com.nohex.aoc.day9

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.flow.toList

internal class MeasureCalculatorTest : ShouldSpec({
    context("The example input") {
        val sut = MeasureCalculator(loadMeasures("example.txt"))

        should("produce the expected result for part 1") {
            val riskLevels = sut.findRiskLevels().toList()
            riskLevels.sum() shouldBe 15
        }

        should("produce the expected result for part 2") {
            sut.getTop3BasinSizeProduct() shouldBe 1134
        }
    }
})
