package com.nohex.aoc.day12

class Cave(val name: String) {
    val isStart = name == START_NAME
    val isEnd = name == END_NAME
    val isSmall = !isStart && !isEnd && name.all { it in ('a'..'z') }

    private var _connections = mutableSetOf<Cave>()
    val connections
        get() = _connections.toSet()

    fun connectTo(cave: Cave) {
        // If the places are already connected, do nothing.
        if (cave in _connections)
            return

        // The end place cannot have outgoing connections.
        // The start place cannot have incoming connections.
        if (!isEnd && !cave.isStart)
            _connections.add(cave)

        // Add a path back to this place.
        cave.connectTo(this)
    }

    override fun toString() = name

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Cave

        if (name != other.name) return false

        return true
    }

    override fun hashCode(): Int {
        return name.hashCode()
    }
}