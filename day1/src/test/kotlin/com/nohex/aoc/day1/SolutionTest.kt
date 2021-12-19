package com.nohex.aoc.day1

import com.nohex.aoc.PuzzleInput
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

internal class SolutionTest : StringSpec({

    "example" {
        Solution().count(getInput()) shouldBe 7
        Solution().countWindows(getInput()) shouldBe 5
    }
})

private fun getInput(): Sequence<Int> =
    PuzzleInput("example.txt")
        .asSequence()
        .map(String::toInt)

