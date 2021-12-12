package com.nohex.aoc.day5

import com.nohex.aoc.PuzzleInput
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class HydrothermalVentMapTest {
    @Test
    fun testStraightLines() {
        val readings = PuzzleInput("example.txt").asSequence()
        val vectors = VectorReader(readings).vectors
            .filter { it.isStraight }

        HydrothermalVentMap(vectors)
            .getOverlapCount(threshold = 2) shouldBe 5
    }

    @Test
    fun testStraightAndDiagonalLines() {
        val readings = PuzzleInput("example.txt").asSequence()
        val vectors = VectorReader(readings).vectors
            .filter { it.isStraight || it.isDiagonal }

        HydrothermalVentMap(vectors)
            .getOverlapCount(threshold = 2) shouldBe 12
    }
}
