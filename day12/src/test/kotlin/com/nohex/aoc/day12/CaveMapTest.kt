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
    should("Example 1 should have 36 longer paths") {
        loadMap("example1.txt").longPathCount shouldBe 36
    }
    should("Example 2 should have 103 longer paths") {
        loadMap("example2.txt").longPathCount shouldBe 103
    }
    should("Example 3 should have 3509 longer paths") {
        loadMap("example3.txt").longPathCount shouldBe 3509
    }
})
