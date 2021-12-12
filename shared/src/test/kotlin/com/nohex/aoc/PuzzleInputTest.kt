package com.nohex.aoc

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class PuzzleInputTest {
    @Test
    fun `should load a resource from the classpath as a sequence of lines`() {
        val sut = PuzzleInput("lines.txt")
        val iterator = sut.asSequence().iterator()
        iterator.next() shouldBe "Line 1"
        iterator.next() shouldBe "Line 2"
        iterator.hasNext() shouldBe false
    }
}
