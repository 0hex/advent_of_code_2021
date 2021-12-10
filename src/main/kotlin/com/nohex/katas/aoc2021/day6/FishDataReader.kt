package com.nohex.katas.aoc2021.day6

class FishDataReader(fishData: Sequence<String>) {
    val fishes = fishData.first().split(",").map { it.toInt() }
}
