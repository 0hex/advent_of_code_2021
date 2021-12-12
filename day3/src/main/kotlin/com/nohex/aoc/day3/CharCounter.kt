package com.nohex.aoc.day3

/**
 * A class that holds counters for several indexes.
 */
internal class CharCounter(private val recordSize: Int, vararg indexes: Char) {

    private val counters = HashMap<Char, IntArray>()

    init {
        counters
        for (index in indexes) {
            counters[index] = IntArray(recordSize)
        }
    }

    fun parse(record: String) {
        for (i in record.indices) {
            increase(record[i], i)
        }
    }

    // Increase a character's count
    private fun increase(character: Char, position: Int) {
        if (!counters.containsKey(character))
            counters[character] = IntArray(recordSize)

        counters[character]!![position]++
    }

    fun getMostCommonCharacters(): String {
        var mostCommonCharacters = ""
        for (i in 0 until recordSize) {
            val keyIterator = counters.iterator()
            val firstCharacterCount = keyIterator.next()
            var mostCommonCharacter = firstCharacterCount.key
            var mostCommonCharacterCount = firstCharacterCount.value[i]
            while (keyIterator.hasNext()) {
                val characterCount = keyIterator.next()
                if (characterCount.value[i] > mostCommonCharacterCount) {
                    mostCommonCharacter = characterCount.key
                    mostCommonCharacterCount = characterCount.value[i]
                }
            }

            mostCommonCharacters += mostCommonCharacter
        }

        return mostCommonCharacters
    }
}
