package com.nohex.aoc.day12

class Path(private val _caves: List<Cave> = mutableListOf()) {
    val places
        get() = _caves.toList()

    override fun toString(): String =
        "Path(${_caves.joinToString("-") { it.name }})"

    // The place can only be visited if it's not a small cave that was visited before.
    fun canVisit(cave: Cave) = !(cave.isSmall && (cave in _caves))
}