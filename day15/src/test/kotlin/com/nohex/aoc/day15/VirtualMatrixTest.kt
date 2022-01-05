package com.nohex.aoc.day15

import com.nohex.aoc.Point
import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe

internal class VirtualMatrixTest : ShouldSpec({
    context("The virtual matrix with a tile factor of 5") {
        val tiledMap = VirtualMatrix(getInput("example.txt"), expansionFactor = 5)

        should("have the appropriate values in both actual and virtual positions") {
            tiledMap[Point(0, 0)] shouldBe 1
            tiledMap[Point(9, 0)] shouldBe 2

            tiledMap[Point(10, 0)] shouldBe 2
            tiledMap[Point(0, 10)] shouldBe 2
            tiledMap[Point(19, 0)] shouldBe 3
            tiledMap[Point(0, 19)] shouldBe 3

            tiledMap[Point(20, 0)] shouldBe 3
            tiledMap[Point(0, 20)] shouldBe 3

            tiledMap[Point(30, 0)] shouldBe 4
            tiledMap[Point(0, 30)] shouldBe 4

            tiledMap[Point(40, 0)] shouldBe 5
            tiledMap[Point(0, 40)] shouldBe 5

            tiledMap[Point(50, 0)] shouldBe null
            tiledMap[Point(0, 50)] shouldBe null
        }

        should("wrap values around 9") {
            tiledMap[Point(4, 0)] shouldBe 7
            tiledMap[Point(14, 0)] shouldBe 8
            tiledMap[Point(24, 0)] shouldBe 9
            tiledMap[Point(34, 0)] shouldBe 1
            tiledMap[Point(44, 0)] shouldBe 2
            tiledMap[Point(54, 0)] shouldBe null
        }
    }
})