package com.nohex.aoc.day10

data class CharacterSet(val opener: Char, val closer: Char, val score: Int)

class ChunkAnalyser(input: Sequence<String>) {
    val corruptedScore
        get() = corruptedScores.sum()
    private val corruptedScores = mutableListOf<Int>()
    private val characterSets = setOf(
        CharacterSet('(', ')', 3),
        CharacterSet('[', ']', 57),
        CharacterSet('{', '}', 1197),
        CharacterSet('<', '>', 25137),
    )
    private val openers = characterSets.map { it.opener }.toSet()
    private val closers = characterSets.map { it.closer }.toSet()

    init {
        input.forEach { analyseLine(it) }
    }

    private fun analyseLine(line: String) {
        val charIterator = line.iterator()
        val stack = ArrayDeque<Char>()
        var isCorrupted = false
        while (charIterator.hasNext() && !isCorrupted) {
            val current = charIterator.nextChar()
            // If it's an opener, add it to the stack.
            if (current in openers)
                stack.addLast(current)
            // If it's a closer, remove it from the stack.
            if (current in closers) {
                val removed = stack.removeLast()
                // Find the matching opener.
                characterSets.find { it.closer == current }?.let {
                    // If the opener is not what was removed from the stack, the line is corrupted.
                    if (it.opener != removed) {
                        // Account for the corrupting character.
                        corruptedScores.add(it.score)
                        isCorrupted = true
                    }
                }
            }
        }
    }
}