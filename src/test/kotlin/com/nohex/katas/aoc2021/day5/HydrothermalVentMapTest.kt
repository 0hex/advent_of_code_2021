package com.nohex.katas.aoc2021.day5

import com.nohex.katas.Resources
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class HydrothermalVentMapTest {
    @Test
    fun testDay1() {
        val readings = Resources.asLines("aoc2021/day5/example.txt")
        val map = MapLoader(readings)
        HydrothermalVentMap(map.vectors)
            .getOverlapCount(threshold = 2) shouldBe 5
    }
}
