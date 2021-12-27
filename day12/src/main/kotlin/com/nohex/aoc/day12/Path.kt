package com.nohex.aoc.day12

class Path(private val _caves: List<Cave> = mutableListOf()) {
    val caves
        get() = _caves.toList()

    override fun toString(): String =
        "Path(${_caves.joinToString("-") { it.name }})"

    // The place can only be visited if it's not a small cave that was visited before.
    fun canVisit(cave: Cave) = !(cave.isSmall && (cave in _caves))

    // The place can be visited if it's not a small cave, or no small caves have been visited more than once.
    fun canVisitTwice(cave: Cave) =
        // The cave is not small.
        !cave.isSmall
                // or, if it is small, it has not been visited.
                || cave !in _caves
                // or, if it is small, and it has been visited, none other has been more than once.
                || (_caves.filter { it.isSmall }.groupingBy { it }.eachCount().values.all { it < 2 })
}