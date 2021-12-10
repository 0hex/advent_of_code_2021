package com.nohex.katas.aoc2021.day4

import com.nohex.katas.Resources

fun main() {
    val settings = Resources.asLines("aoc2021/day4/input.txt")

    GameSettings(settings).run {
        println(Game(boards).getLastCompletedBoard(plays)?.score)
    }
}
