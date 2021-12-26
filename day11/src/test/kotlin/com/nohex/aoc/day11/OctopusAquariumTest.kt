package com.nohex.aoc.day11

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe

internal class OctopusAquariumTest : ShouldSpec({
    context("The dumbo octopus aquarium") {
        val input = getInput("example.txt")
        val initialMap = OctopusMapBuilder().load(input)
        val sut = OctopusAquarium(initialMap.values.toMutableSet())

        should("have seen 1656 flashes after 100 iterations") {
            repeat(100) { sut.step() }
            sut.flashCount shouldBe 1656
        }

        should("have a full-aquarium flash at the 195th iteration") {
            while (!sut.allFlashed) {
                sut.step()
            }

            sut.iteration shouldBe 195
        }
    }
})
