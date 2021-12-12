package com.nohex.aoc.day6

import com.nohex.aoc.PuzzleInput
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class AquariumTest {
    @Test
    fun testExample() {
        val fishData = PuzzleInput("example.txt").asSequence()
        val initialGeneration = FishDataReader(fishData).fishes
        val sut = Aquarium(initialGeneration)
        sut.after(days = 18) shouldBe 26
        sut.after(days = 80) shouldBe 5934
    }
}
