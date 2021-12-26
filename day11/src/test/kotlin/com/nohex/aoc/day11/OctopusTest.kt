package com.nohex.aoc.day11

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.collections.shouldContain
import io.kotest.matchers.shouldBe

internal class OctopusTest : ShouldSpec({
    context("An octopus") {
        val octopus1 = Octopus(1)
        val octopus2 = Octopus(9)
        octopus1.addNeighbour(octopus2)

        should("have an energy level") {
            octopus1.level shouldBe 1
            octopus2.level shouldBe 9
        }

        should("know its neighbours") {
            octopus1.neighbours shouldContain octopus2
        }

        should("be known to its neighbours") {
            octopus2.neighbours shouldContain octopus1
        }

        should("flash when its energy level is increased beyond 9") {
            val flashers = mutableSetOf<Octopus>()
            octopus2.increaseLevel(flashers)
            octopus2.level shouldBe 0
            octopus1.level shouldBe 2
        }
    }
})