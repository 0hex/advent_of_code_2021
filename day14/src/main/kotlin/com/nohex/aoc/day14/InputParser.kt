package com.nohex.aoc.day14

val RULE_PATTERN = """(\w\w) -> (\w)""".toRegex()

/**
 * Parses the puzzle input into usable objects.
 */
class InputParser(input: Sequence<String>) {
    val template: String
    val insertionRules: Map<String, Char>

    init {
        val iterator = input.iterator()

        // Get the polymer template in the first line.
        template = iterator.next()

        val tempInsertionRules = mutableMapOf<String, Char>()
        while (iterator.hasNext()) {
            RULE_PATTERN.matchEntire(iterator.next())
                ?.destructured
                ?.let { (pair, insertion) ->
                    tempInsertionRules[pair] = insertion.toCharArray().first()
                }
        }

        insertionRules = tempInsertionRules.toMap()
    }
}
