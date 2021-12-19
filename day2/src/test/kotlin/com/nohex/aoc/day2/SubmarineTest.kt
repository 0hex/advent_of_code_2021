package com.nohex.aoc.day2

import com.nohex.aoc.PuzzleInput
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

internal class SubmarineTest : StringSpec({

    "example" {
        val sut = Submarine()

        PuzzleInput("example.txt")
            .asSequence()
            .filter(String::isNotBlank)
            .forEach { sut.move(it) }

        sut.position shouldBe Pair(15, 60)
    }
})
