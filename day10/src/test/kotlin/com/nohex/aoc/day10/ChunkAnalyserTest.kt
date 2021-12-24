package com.nohex.aoc.day10

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe

internal class ChunkAnalyserTest : ShouldSpec({
    context("The example puzzle input") {
        val input = getInput("example.txt")
        val sut = ChunkAnalyser(input)

        should("produce the expected result for day 1") {
            sut.corruptedScore shouldBe 26397
        }

        should("produce the expected result for part 2") {
            sut.middleScore shouldBe 288957
        }
    }
})
