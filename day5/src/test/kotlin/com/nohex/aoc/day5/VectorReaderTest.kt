package com.nohex.aoc.day5

import com.nohex.aoc.Point
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.sequences.shouldContain

internal class VectorReaderTest : StringSpec({
    "loader" {
        val readings = sequenceOf(
            "1,2->3,2",
            "3, 1 -> 3, 3",
            "   5,  6    ->     7,    8    "
        )

        val sut = VectorReader(readings)

        sut.vectors shouldContain Vector(Point(1, 2), Point(3, 2))
        sut.vectors shouldContain Vector(Point(3, 1), Point(3, 3))
        sut.vectors shouldContain Vector(Point(5, 6), Point(7, 8))
    }
})
