package com.nohex.aoc.day14

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.maps.shouldContain
import io.kotest.matchers.shouldBe

internal class InputParserTest : ShouldSpec({
    context("The input parser") {
        val sut = InputParser(
            """
                AB
                
                AB -> C
            """.trimIndent().lineSequence()
        )

        should("parse templates and insertion pair rules") {
            sut.template shouldBe "AB"
            sut.insertionRules shouldContain Pair(Pair('A', 'B'), 'C')
        }
    }
})