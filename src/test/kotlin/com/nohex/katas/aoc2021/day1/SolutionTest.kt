package com.nohex.katas.aoc2021.day1

import com.nohex.katas.Resources
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class SolutionTest {

    @Test
    fun testExample() {
        Solution().count(getInput()) shouldBe 7
        Solution().countWindows(getInput()) shouldBe 5
    }

    private fun getInput(): Sequence<Int> =
        Resources.asLines("aoc2021/day1/example.txt").map(String::toInt)
}
