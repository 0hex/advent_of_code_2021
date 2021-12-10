package com.nohex.katas.aoc2021.day6

import com.nohex.katas.Resources
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class AquariumTest {
    @Test
    fun testExample() {
        val fishData = Resources.asLines("aoc2021/day6/example.txt")
        val initialGeneration = FishDataReader(fishData).fishes
        val sut = Aquarium(initialGeneration)
        sut.after(days = 18) shouldBe 26
        sut.after(days = 80) shouldBe 5934
    }
}
