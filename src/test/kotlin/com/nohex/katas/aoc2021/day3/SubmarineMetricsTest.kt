package com.nohex.katas.aoc2021.day3

import com.nohex.katas.Resources
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
        Resources.asLines("aoc2021/day3/example.txt")
            .filter(String::isNotBlank)
}
