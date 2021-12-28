package com.nohex.aoc.day13

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe

internal class FoldingMapTest : ShouldSpec({
    context("The example puzzle input") {
        val mapData = MapData(getInput("example.txt"))
        val sut = FoldingMap(mapData.dots)
        val instructionIterator = mapData.instructions.iterator()

        should("the first fold should leave 17 dots") {
            sut.fold(instructionIterator.next())
            sut.dotCount shouldBe 17
        }

        should("the second fold should leave 16 dots") {
            sut.fold(instructionIterator.next())
            sut.dotCount shouldBe 16
        }
    }
})
