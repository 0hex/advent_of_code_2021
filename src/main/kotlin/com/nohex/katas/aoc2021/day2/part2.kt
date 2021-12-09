package com.nohex.katas.aoc2021.day2

import com.nohex.katas.Resources

fun main() {
    val submarine = Submarine()
    val instructions = getInput()
    instructions.forEach(submarine::move)
    println("Position: " + submarine.position)
}

private fun getInput() =
    Resources.asLines("aoc2021/day2/input.txt")
        .filter(String::isNotBlank)
