package com.nohex.katas.aoc2021.day5

import io.kotest.matchers.sequences.shouldContain
import org.junit.jupiter.api.Test

internal class MapLoaderTest {
    @Test
    fun testLoader() {
        val readings = sequenceOf(
            "1,2->3,2",
            "3, 1 -> 3, 3",
            "   5,  6    ->     7,    8    "
        )

        val sut = MapLoader(readings)

        sut.vectors shouldContain Vector(1, 2, 3, 2)
        sut.vectors shouldContain Vector(3, 1, 3, 3)
    }
}
