package com.nohex.aoc.day15

import com.nohex.aoc.Matrix
import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe

internal class PathComputerTest : ShouldSpec({
    context("The example puzzle input") {

        should("produce the expected result for day 1") {
            val riskMatrix = Matrix(getInput("example.txt"))
            val sut = PathComputer(riskMatrix)
            sut.lowestRisk shouldBe 40
        }

        should("produce the expected result for day 2") {
            val riskMatrix = VirtualMatrix(getInput("example.txt"), expansionFactor = 5)
            val sut = PathComputer(riskMatrix)
            sut.lowestRisk shouldBe 315
        }
    }

    context("A risk map with a clear path") {
        val map = VirtualMatrix(
            """
            11199
            99199
            99199
            99199
            99111
        """.trimIndent().lineSequence()
        )
        val sut = PathComputer(map)

        should("follow that path") {
            sut.lowestRisk shouldBe 8
        }
    }

    context("A risk map with a winding path") {
        val map = VirtualMatrix(
            """
            19111
            19191
            11191
            99991
            99111
            99199
            99111
        """.trimIndent().lineSequence()
        )
        val sut = PathComputer(map)

        should("follow that path") {
            sut.lowestRisk shouldBe 18
        }
    }
})
