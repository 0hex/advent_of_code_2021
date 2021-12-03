package com.nohex.katas.aoc2021.day2

import com.nohex.katas.Resources
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class SolutionTest {

    /**
     * Test the example in the puzzle description.
     */
    @Test
    fun testExample() {
        Solution().getPosition(getInput()) shouldBe Pair(15, 60)
    }

    private fun getInput(): Sequence<String> =
        Resources.asLines("aoc2021/day2/example.txt")
            .filter(String::isNotBlank)
}
