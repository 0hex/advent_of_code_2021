package com.nohex.katas.aoc2021.day5

/** Produces a list of vectors from an appropriately formatted string sequence, e.g.:
 * <pre>
 * 1, 2 -> 3, 4
 * ...
 * </pre>
 */
class MapLoader(readings: Sequence<String>) {
    private val readingPattern = """\s*(\d+)\s*,\s*(\d+)\s*->\s*(\d+)\s*,\s*(\d+)\s*""".toRegex()
    val vectors: Sequence<Vector>

    init {
        vectors = readings
            .filter { it.isNotBlank() }
            .map { readingPattern.find(it) }
            .filterNotNull()
            .map { it.groupValues }
            .map { matches ->
                Vector(
                    startX = matches[1].toInt(),
                    startY = matches[2].toInt(),
                    endX = matches[3].toInt(),
                    endY = matches[4].toInt()
                )
            }
            // Keep only the vectors that define straight lines.
            .filter { it.startX == it.endX || it.startY == it.endY }
    }
}
