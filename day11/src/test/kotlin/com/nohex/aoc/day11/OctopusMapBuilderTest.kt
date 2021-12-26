package com.nohex.aoc.day11

import com.nohex.aoc.Point
import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe

internal class OctopusMapBuilderTest : ShouldSpec({
    context("The example input") {
        val input = getInput("example.txt")
        val sut = OctopusMapBuilder()

        should("have the expected values in the expected positions") {
            val octopusMap = sut.load(input)
            octopusMap[Point(0, 0)]?.level shouldBe 5
            octopusMap[Point(9, 9)]?.level shouldBe 6
        }
    }
})