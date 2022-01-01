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
            sut.polymer shouldBe "NCNBCHB"

            // Step 2
            sut.step()
            sut.polymer shouldBe "NBCCNBBBCBHCB"

            // Step 3
            sut.step()
            sut.polymer shouldBe "NBBBCNCCNBBNBNBBCHBHHBCHB"

            // Step 4
            sut.step()
            sut.polymer shouldBe "NBBNBNBBCCNBCNCCNBBNBBNBBBNBBNBBCBHCBHHNHCBBCBHCB"

            // Step 5
            sut.step()
            sut.polymer.length shouldBe 97

            // Step 10
            repeat(5) { sut.step() }
            sut.polymer.length shouldBe 3073
            sut.counts['B'] shouldBe 1749
            sut.counts['C'] shouldBe 298
            sut.counts['H'] shouldBe 161
            sut.counts['N'] shouldBe 865

            with(sut) {
                counts.maxOf { it.value } - counts.minOf { it.value } shouldBe 1588
            }
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
                sut.polymer shouldBe "ABCD"
            }
        }
    }
})
