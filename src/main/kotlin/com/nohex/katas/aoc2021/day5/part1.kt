package com.nohex.katas.aoc2021.day5

import com.nohex.katas.Resources

fun main() {
    val readings = Resources.asLines("aoc2021/day5/input.txt")
    val map = MapLoader(readings)
    println(HydrothermalVentMap(map.vectors).getOverlapCount(threshold = 2))
}
