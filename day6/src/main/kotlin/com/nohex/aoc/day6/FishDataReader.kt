package com.nohex.aoc.day6

class FishDataReader(fishData: Sequence<String>) {
    val fishes = fishData.first().split(",").map { it.toInt() }
}
