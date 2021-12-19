package com.nohex.aoc.day6

import com.nohex.aoc.PuzzleInput
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

internal class AquariumTest : StringSpec({
    "example" {
        val fishData = PuzzleInput("example.txt").asSequence()
        val initialGeneration = FishDataReader(fishData).fishes
        val sut = Aquarium(initialGeneration)
        sut.after(days = 18) shouldBe 26
        sut.after(days = 80) shouldBe 5934
    }
})
