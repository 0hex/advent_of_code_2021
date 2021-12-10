package com.nohex.katas.aoc2021.day6

import com.nohex.katas.Resources

fun main() {
    val fishData = Resources.asLines("aoc2021/day6/input.txt")
    val initialFishPopulation = FishDataReader(fishData).fishes

    println(Aquarium(initialFishPopulation).after(days = 80))
}
