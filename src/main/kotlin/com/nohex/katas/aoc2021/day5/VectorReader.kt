package com.nohex.katas.aoc2021.day5

/** Produces a list of vectors from an appropriately formatted string sequence, e.g.:
 * <pre>
 * 1, 2 -> 3, 4
 * ...
 * </pre>
 */
class VectorReader(readings: Sequence<String>) {
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
                    Point(
                        x = matches[1].toInt(),
                        y = matches[2].toInt()
                    ),
                    Point(
                        x = matches[3].toInt(),
                        y = matches[4].toInt()
                    )
                )
            }
    }
}
