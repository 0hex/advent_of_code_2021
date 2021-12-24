package com.nohex.aoc.day10

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe

internal class ChunkAnalyserTest : ShouldSpec({
    context("The example puzzle input") {
        val input = getInput("example.txt")
        val sut = ChunkAnalyser(input)

        should("produce the expected result") {
            sut.corruptedScore shouldBe 26397
        }
    }
})
