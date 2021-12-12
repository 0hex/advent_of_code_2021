package com.nohex.aoc.day2

import com.nohex.aoc.PuzzleInput
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class SubmarineTest {

    @Test
    fun testExample() {
        val sut = Submarine()
        getMoves().forEach { sut.move(it) }

        sut.position shouldBe Pair(15, 60)
    }

    private fun getMoves(): Sequence<String> =
        PuzzleInput("example.txt")
            .asSequence()
            .filter(String::isNotBlank)
}
