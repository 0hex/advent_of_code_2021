package com.nohex.aoc.day13

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe

internal class MapDataTest : ShouldSpec({
    context("Map data from the example") {
        val sut = MapData(getInput("example.txt"))

        should("produce a 11x15 map") {
            sut.width shouldBe 11
            sut.height shouldBe 15
        }

        should("contain 18 dots") {
            sut.dots.count() shouldBe 18
        }

        should("contain 2 fold instructions") {
            sut.instructions.count() shouldBe 2
        }
    }
})