package com.nohex.aoc.day12

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe

internal class CaveMapTest : ShouldSpec({
    should("Example 1 should have 10 paths") {
        loadMap("example1.txt").pathCount shouldBe 10
    }
    should("Example 2 should have 19 paths") {
        loadMap("example2.txt").pathCount shouldBe 19
    }
    should("Example 3 should have 226 paths") {
        loadMap("example3.txt").pathCount shouldBe 226
    }
})
