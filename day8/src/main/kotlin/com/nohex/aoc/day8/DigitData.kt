package com.nohex.aoc.day8

/**
 * Decodes information about a group of 7-segment digits
 * and their wiring definitions.
 *
 * Digits are composed of 7 segments:
 *    N
 * NW   NE
 *    M
 * SW   SE
 *    S
 *
 * Digits have the following segments:
 * 0 -> N NW NE   SW SE S
 * 1 ->      NE      SE
 * 2 -> N    NE M SW    S
 * 3 -> N    NE M    SE S
 * 4 ->   NW NE M    SE
 * 5 -> N NW    M    SE S
 * 6 -> N NW    M SW SE S
 * 7 -> N    NE      SE
 * 8 -> N NW NE M SW SE S
 * 9 -> N NW NE M    SE S
 */
class DigitData(input: String) {
    val decodedNumber: Int
    val digits: List<Digit>
    val wiring: Map<Int, Digit>

    init {
        val (definitionData, digitData) = input.split(" | ")
        val definitions = definitionData
            .split(" ")
            .map { Digit(it) }
        digits = digitData
            .split(" ")
            .map { Digit(it) }

        // Classify definitions into digits.
        wiring = inferWiring(definitions)
        decodedNumber = decodeNumber(digits)
    }

    /**
     * Finds out which number is being displays, given the [wiring] and the [digits].
     */
    private fun decodeNumber(digits: List<Digit>): Int =
        digits
            // Get the number that corresponds to the wiring in the digit.
            .map { digit -> wiring.filterValues { it == digit }.keys.first() }
            // Add each digit to a string.
            .joinToString("")
            // Take the numeric value of the string.
            .toInt()

    /**
     * Extend mutable lists with the ability to find an element,
     * remove it from the list and return it.
     */
    private fun MutableList<Digit>.findAndRemove(filter: (Digit) -> Boolean): Digit? {
        // Find the item.
        val item = find(filter)
        // Remove it.
        remove(item)
        // Return the found item.
        return item
    }

    private fun inferWiring(definitions: List<Digit>): Map<Int, Digit> {
        // Copy the wiring definitions to a list which
        // elements are removed from as they are matched
        // to a digit.
        val workingDefs = definitions.toMutableList()
        // Create a dictionary of numbers vs. segment groups.
        val wiring = mutableMapOf<Int, Digit>()
        // Find the 1, it has 2 segments.
        wiring[1] = workingDefs.findAndRemove { it.segmentCount == 2 }
            ?: throw IllegalStateException("No digit 1 was defined")
        val digitOne = wiring[1]!!
        // Find the 4, it has 4 segments.
        wiring[4] = workingDefs.findAndRemove { it.segmentCount == 4 }
            ?: throw IllegalStateException("No digit 4 was defined")
        // Find the 7, it has 3 segments.
        wiring[7] = workingDefs.findAndRemove { it.segmentCount == 3 }
            ?: throw IllegalStateException("No digit 7 was defined")
        // Find the 8, it has all 7 segments.
        wiring[8] = workingDefs.findAndRemove { it.segmentCount == 7 }
            ?: throw IllegalStateException("No digit 8 was defined")
        // Out of the 6-segment digits, 6 does not contain all segments in 1.
        wiring[6] = workingDefs
            .findAndRemove { it.segmentCount == 6 && !(it contains digitOne) }
            ?: throw IllegalStateException("No 6 digit was defined")
        // Out of the 5-segment digits, only 3 contains all segments in 1.
        wiring[3] = workingDefs
            .findAndRemove { it.segmentCount == 5 && it contains digitOne }
            ?: throw IllegalStateException("No 3 digit was defined")
        // Out of the two remaining 5-segment digits, digit 6 contains all segments in 5.
        wiring[5] = workingDefs
            .findAndRemove { it.segmentCount == 5 && wiring[6]!! contains it }
            ?: throw IllegalStateException("No 5 digit was defined")
        // The only remaining 5-segment digit is 2.
        wiring[2] = workingDefs
            .findAndRemove { it.segmentCount == 5 }
            ?: throw IllegalStateException("No 2 digit was defined")
        // The SE segment is what remains from digit 2 without digit 3's segments.
        val swSegment = (wiring[2]!! minus wiring[3]!!)
            .also { if (it.size > 1) throw IllegalStateException("Only one segment should remain") }
            .first()
        // Out of the remaining wiring definitions, only 0 has an SW segment.
        wiring[0] = workingDefs
            .findAndRemove { it contains swSegment }
            ?: throw IllegalStateException("No 0 digit was defined")

        if (workingDefs.size > 1)
            throw IllegalStateException("Only one digit definition should remain, ${workingDefs.size} are still left")
        // The remaining wiring definition is for digit 0.
        wiring[9] = workingDefs.first()

        return wiring.toMap()
    }
}
