package com.nohex.aoc.day8

const val MIN = 'a'
const val MAX = 'g'

/**
 * A group of up to 7 segments identifying a digit.
 *
 * https://en.wikipedia.org/wiki/Seven-segment_display
 */
class Digit(input: String) {
    val segments = input.toCharArray().sortedArray()
    val segmentCount = segments.size

    init {
        // The string should only contain at most 7 characters between
        // 'a' and 'g' for segments 0 to 7.
        if (input.length > 7)
            throw IllegalArgumentException("Only up to 7 characters are allowed")
        if (!input.all { it in MIN..MAX })
            throw IllegalArgumentException("Only characters from 'a' to 'g' are allowed")
    }

    /**
     * Whether the current digit contains all segments in [other].
     */
    infix fun contains(other: Digit): Boolean =
        other.segments.all { segments.contains(it) }

    /**
     * Whether the current digit contains the given [segment].
     */
    infix fun contains(segment: Char): Boolean =
        segments.contains(segment)

    /**
     * Returns the segments left in this digit after removing the ones in [other].
     */
    infix fun minus(other: Digit): CharArray =
        segments.filter { !other.segments.contains(it) }.toCharArray()

    override fun toString(): String =
        segments.joinToString("")

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Digit) return false

        if (!segments.contentEquals(other.segments)) return false

        return true
    }

    override fun hashCode(): Int {
        return segments.hashCode()
    }
}
