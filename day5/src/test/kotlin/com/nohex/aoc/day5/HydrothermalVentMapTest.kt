package com.nohex.aoc.day5

import com.nohex.aoc.PuzzleInput
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

internal class HydrothermalVentMapTest : StringSpec({
    "straight lines" {
        val readings = PuzzleInput("example.txt").asSequence()
        val vectors = VectorReader(readings).vectors
            .filter { it.isStraight }

        HydrothermalVentMap(vectors)
            .getOverlapCount(threshold = 2) shouldBe 5
    }

    "diagonal lines" {
        val readings = PuzzleInput("example.txt").asSequence()
        val vectors = VectorReader(readings).vectors
            .filter { it.isStraight || it.isDiagonal }

        HydrothermalVentMap(vectors)
            .getOverlapCount(threshold = 2) shouldBe 12
    }
})
