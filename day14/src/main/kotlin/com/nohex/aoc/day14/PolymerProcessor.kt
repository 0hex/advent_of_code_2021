package com.nohex.aoc.day14

class PolymerProcessor(template: String, private val insertionRules: Map<Pair<Char, Char>, Char>) {
    val elementCounts: Map<Char, Long>
        get() = _elementCounts.toMap()

    private val _elementCounts = mutableMapOf<Char, Long>()
    private val pairCounts = mutableMapOf<Pair<Char, Char>, Long>()

    init {
        template.windowed(size = 2).forEach {
            val first = it[0]
            val second = it[1]
            // Account for this pair.
            pairCounts.merge(Pair(first, second), 1, Long::plus)
            // Only count the pair's first, as it the previous pair's last.
            incElementCount(first)
        }
        // Account for the last pair's last element.
        incElementCount(template.last())
    }

    /**
     * Increases the count of the [element].
     */
    private fun incElementCount(element: Char, increment: Long = 1L) {
        _elementCounts.merge(element, increment, Long::plus)
    }

    fun step() {
        // Use a snapshot of the pair count map to traverse the paths.
        val pairsToCheck = pairCounts.toMap()

        // For each insertion rule...
        insertionRules.forEach { insertionRule ->
            val pair = insertionRule.key
            // ... if there is a pair of elements...
            pairsToCheck[pair]?.let { pairCount ->
                val insertion = insertionRule.value
                // ... replace the pair with the two resulting pairs
                // as many times as necessary (pairCount).

                // Decrease the pair count.
                val remaining = pairCounts.merge(pair, pairCount, Long::minus)
                if (remaining != null && remaining < 1) {
                    // Remove the pair if none are left.
                    pairCounts.remove(pair)
                }

                // Update the left pair.
                val leftPair = Pair(pair.first, insertion)
                pairCounts.merge(leftPair, pairCount, Long::plus)

                // Update the right pair.
                val rightPair = Pair(insertion, pair.second)
                pairCounts.merge(rightPair, pairCount, Long::plus)

                // Update the count.
                incElementCount(insertion, pairCount)
            }
        }
    }
}