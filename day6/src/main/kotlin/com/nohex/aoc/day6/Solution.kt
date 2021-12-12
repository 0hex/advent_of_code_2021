package com.nohex.aoc.day6

import com.nohex.aoc.PuzzleInput

fun main() {
    val fishData = PuzzleInput("input.txt").asSequence()
    val initialFishPopulation = FishDataReader(fishData).fishes

    println("Day 6, part 1: " + Aquarium(initialFishPopulation).after(days = 80))
    println("Day 6, part 2: " + Aquarium(initialFishPopulation).after(days = 256))
}
