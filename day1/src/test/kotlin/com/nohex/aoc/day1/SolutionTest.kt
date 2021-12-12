package com.nohex.aoc.day1

import com.nohex.aoc.PuzzleInput
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class SolutionTest {

    @Test
    fun testExample() {
        Solution().count(getInput()) shouldBe 7
        Solution().countWindows(getInput()) shouldBe 5
    }

    private fun getInput(): Sequence<Int> =
        PuzzleInput("example.txt")
            .asSequence()
            .map(String::toInt)
}
