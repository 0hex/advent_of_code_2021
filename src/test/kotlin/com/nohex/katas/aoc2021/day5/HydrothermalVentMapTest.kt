package com.nohex.katas.aoc2021.day5

import com.nohex.katas.Resources
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class HydrothermalVentMapTest {
    @Test
    fun testStraightLines() {
        val readings = Resources.asLines("aoc2021/day5/example.txt")
        val vectors = VectorReader(readings).vectors
            .filter { it.isStraight }

        HydrothermalVentMap(vectors)
            .getOverlapCount(threshold = 2) shouldBe 5
    }

    @Test
    fun testStraightAndDiagonalLines() {
        val readings = Resources.asLines("aoc2021/day5/example.txt")
        val vectors = VectorReader(readings).vectors
            .filter { it.isStraight || it.isDiagonal }

        HydrothermalVentMap(vectors)
            .getOverlapCount(threshold = 2) shouldBe 12
    }
}
