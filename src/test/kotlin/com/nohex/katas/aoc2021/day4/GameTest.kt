package com.nohex.katas.aoc2021.day4

import com.nohex.katas.Resources
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class GameTest {
    @Test
    fun testExample() {
        val settings = Resources.asLines("aoc2021/day4/example.txt")
        GameSettings(settings).run {
            Game(boards).play(plays).getScore() shouldBe 4512
        }
    }

    @Test
    fun testSmallExample() {
        val settings = Resources.asLines("aoc2021/day4/small.txt")
        GameSettings(settings).run {
            Game(boards).play(plays).getScore() shouldBe 243
        }
    }
}
