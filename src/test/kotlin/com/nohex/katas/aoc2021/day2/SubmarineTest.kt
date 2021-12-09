package com.nohex.katas.aoc2021.day2

import com.nohex.katas.Resources
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class SubmarineTest {

    /**
     * Test the example in the puzzle description.
     */
    @Test
    fun testExample() {
        val sut = Submarine()
        getMoves().forEach { sut.move(it) }

        sut.position shouldBe Pair(15, 60)
    }

    private fun getMoves(): Sequence<String> =
        Resources.asLines("aoc2021/day2/example.txt")
            .filter(String::isNotBlank)
}
