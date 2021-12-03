package com.nohex.katas.aoc2021.day1

import com.nohex.katas.Resources
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class SolutionTest {

    /**
     * Test the example in the puzzle description.
     */
    @Test
    fun testExample() {
        // Given
        val measurements = Resources.asLines("aoc2021/day1/example.txt")
            .map(String::toInt)

        // When
        val increases = Solution().count(measurements)

        // Then
        increases shouldBe 7
    }
}
