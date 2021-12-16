package com.nohex.aoc.day8

/**
 * A group of segments identifying a digit.
 * The string should only contain characters between 'a' and 'g'
 * for segments 0 to 7.
 */
class SegmentGroup(definition: String) {
    val segments = definition.length
    private val hashCode: Int

    // The value will leave an 'a' as a 1.
    private val aValue = 'a'.code + 1

    init {
        // Calculate a hash based on the numeric value of the letters,
        // irrespective of their order.
        // The maximum number should be 7^7 (chars^segments), well
        // within the range of an Int.
        hashCode = definition.chars()
            // Reduce the numeric value to 0-7.
            .map { it - aValue }
            // Multiply all values.
            .reduce { acc, i -> acc * i }.asInt
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is SegmentGroup) return false

        if (hashCode != other.hashCode) return false

        return true
    }

    override fun hashCode(): Int {
        return hashCode
    }
}
