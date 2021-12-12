package com.nohex.aoc.day3

import com.nohex.aoc.PuzzleInput
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class SubmarineMetricsTest {
    @Test
    fun testPowerConsumption() {
        SubmarineMetrics().getPowerConsumption(getInput()) shouldBe 198
    }

    @Test
    fun testLifeSupportRating() {
        SubmarineMetrics().getLifeSupportRating(getInput()) shouldBe 230
    }

    private fun getInput(): Sequence<String> =
        PuzzleInput("example.txt").asSequence()
            .filter(String::isNotBlank)
}
