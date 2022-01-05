package com.nohex.aoc

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe

internal class MatrixTest : ShouldSpec({
    context("A 9x9 matrix laid out as a sudoku") {
        val source = """
            534678912
            672195348
            198342567
            859761423
            426853791
            713924856
            961537284
            287419635
            345286179
        """.trimIndent()
        val sudoku = Matrix(source.lineSequence())
        val sum = 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9

        should("have a string representation matching the input") {
            sudoku.toString().trim() shouldBe source
        }

        should("have rows that add up to the same number") {
            (0..8).map { row ->
                (0..8)
                    .mapNotNull { sudoku[Point(it, row)] }
                    .sumOf { it } shouldBe sum
            }
        }

        should("have columns that add up to the same number") {
            (0..8).map { column ->
                (0..8)
                    .mapNotNull { sudoku[Point(column, it)] }
                    .sumOf { it } shouldBe sum
            }
        }
    }
})