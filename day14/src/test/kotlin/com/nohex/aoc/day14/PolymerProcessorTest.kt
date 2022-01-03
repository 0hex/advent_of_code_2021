package com.nohex.aoc.day14

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe

internal class PolymerProcessorTest : ShouldSpec({
    context("The example puzzle input") {
        val input = getInput("example.txt")
        val sut = with(InputParser(input)) {
            PolymerProcessor(template, insertionRules)
        }

        should("produce the expected result") {
            // Step 1
            sut.step()
            sut.elementCounts shouldBe countOf("NCNBCHB")

            // Step 2
            sut.step()
            sut.elementCounts shouldBe countOf("NBCCNBBBCBHCB")

            // Step 3
            sut.step()
            sut.elementCounts shouldBe countOf("NBBBCNCCNBBNBNBBCHBHHBCHB")

            // Step 4
            sut.step()
            sut.elementCounts shouldBe countOf("NBBNBNBBCCNBCNCCNBBNBBNBBBNBBNBBCBHCBHHNHCBBCBHCB")

            // Step 5
            sut.step()

            // Step 10
            repeat(5) { sut.step() }
            sut.elementCounts['B'] shouldBe 1749
            sut.elementCounts['C'] shouldBe 298
            sut.elementCounts['H'] shouldBe 161
            sut.elementCounts['N'] shouldBe 865

            with(sut) {
                elementCounts.maxOf { it.value } - elementCounts.minOf { it.value } shouldBe 1588
            }

            // Step 40
            repeat(30) { sut.step() }
            sut.elementCounts.maxOf { it.value } shouldBe 2192039569602
            sut.elementCounts.minOf { it.value } shouldBe 3849876073
        }
    }

    context("A template and rule set with one possible insertion") {
        val sut = with(
            InputParser(
                """
                ACD
                
                AC -> B
            """.trimIndent().lineSequence()
            )
        ) {
            PolymerProcessor(template, insertionRules)
        }

        should("always produce the same polymer") {
            repeat(3) {
                sut.step()
                sut.elementCounts shouldBe mapOf(
                    'A' to 1,
                    'B' to 1,
                    'C' to 1,
                    'D' to 1,
                )
            }
        }
    }
})

fun countOf(polymer: String): Map<Char, Int> =
    polymer.toCharArray().toList().groupingBy { it }.eachCount()
