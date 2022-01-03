package com.nohex.aoc.day14

val RULE_PATTERN = """(\w\w) -> (\w)""".toRegex()

/**
 * Parses the puzzle input into usable objects.
 */
class InputParser(input: Sequence<String>) {
    val template: String
    val insertionRules: Map<Pair<Char, Char>, Char>

    init {
        val iterator = input.iterator()

        // Get the polymer template in the first line.
        template = iterator.next()

        val tempInsertionRules = mutableMapOf<Pair<Char, Char>, Char>()
        while (iterator.hasNext()) {
            RULE_PATTERN.matchEntire(iterator.next())
                ?.destructured
                ?.let { (pairString, insertion) ->
                    val pair = Pair(pairString[0], pairString[1])
                    tempInsertionRules[pair] = insertion.toCharArray().first()
                }
        }

        insertionRules = tempInsertionRules.toMap()
    }
}
