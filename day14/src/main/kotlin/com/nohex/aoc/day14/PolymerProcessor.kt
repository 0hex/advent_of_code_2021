package com.nohex.aoc.day14

class PolymerProcessor(template: String, private val insertionRules: Map<String, Char>) {
    val polymer
        get() = currentPolymer.joinToString("")
    val counts
        get() = currentPolymer.groupingBy { it }.eachCount()

    private var currentPolymer = template.toList()

    fun step() {
        // For each two elements...
        currentPolymer = currentPolymer.windowed(size = 2) { pair ->
            // Add the first element.
            mutableListOf(pair.first()).also { list ->
                // If there is an insertion rule for the current character pair...
                insertionRules[pair.joinToString("")]?.let {
                    // ... append the corresponding character.
                    list += it
                    // The last element of the pair is left out, as it is the
                    // first element of the next pair.
                }
            }
        }
            .flatten()
            // Add the last character.
            .plus(currentPolymer.last())
    }
}