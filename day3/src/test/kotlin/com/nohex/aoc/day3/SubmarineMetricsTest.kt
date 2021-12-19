package com.nohex.aoc.day3

import com.nohex.aoc.PuzzleInput
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

internal class SubmarineMetricsTest : StringSpec({
    "power consumption" {
        SubmarineMetrics().getPowerConsumption(getInput()) shouldBe 198
    }

    "life support" {
        SubmarineMetrics().getLifeSupportRating(getInput()) shouldBe 230
    }
})

private fun getInput(): Sequence<String> =
    PuzzleInput("example.txt").asSequence()
        .filter(String::isNotBlank)
