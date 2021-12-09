package com.nohex.katas.aoc2021.day3

internal class SubmarineMetrics {

    fun getPowerConsumption(diagnostics: Sequence<String>): Int {
        val iterator = diagnostics.iterator()
        if (!iterator.hasNext()) {
            return 0
        }

        // Obtain the record size from the first record.
        val record = iterator.next()
        val recordSize = record.length
        // Set up counters that tally the occurrences of each character
        // in each of the positions of the record.
        val counter = CharCounter(recordSize)
        // Parse the first record.
        counter.parse(record)
        // Parse the rest of the records.
        while (iterator.hasNext()) {
            counter.parse(iterator.next())
        }

        // Add a 0 in front of the counter to avoid the 2's complement nature
        // of inv() from miscalculating the epsilon rate.
        val mostCommonCharacters = "0" + counter.getMostCommonCharacters()
        // Convert binary to integer.
        val gammaRate = mostCommonCharacters.toInt(2)
        val epsilonRate = (1 shl recordSize) + gammaRate.inv()

        return gammaRate * epsilonRate
    }

    fun getLifeSupportRating(diagnostics: Sequence<String>): Int {
        val iterator = diagnostics.iterator()
        if (!iterator.hasNext()) {
            return 0
        }

        // Set up the initial run.
        var position = 0
        val counts = getCounts(iterator, position)

        val top = counts.maxByOrNull { it.value.size }!!.value
        val bottom = counts.minByOrNull { it.value.size }!!.value

        // Increase the position.
        position++
        // Reduce most used.
        val oxygenGeneratorRating =
            reduce(top, position, '1') { c -> c.maxByOrNull { it.value.size }!!.value }
        // Reduce least used.
        val co2ScrubberRating =
            reduce(bottom, position, '0') { c -> c.minByOrNull { it.value.size }!!.value }

        return oxygenGeneratorRating * co2ScrubberRating
    }

    private fun getCounts(
        recordIterator: Iterator<String>,
        position: Int
    ): Map<Char, List<String>> {
        val counts = mutableMapOf<Char, MutableList<String>>()
        while (recordIterator.hasNext()) {
            // Classify the records according to the character
            // in the specified position.
            val record = recordIterator.next()
            val value = record[position]
            if (!counts.containsKey(value))
                counts[value] = mutableListOf()
            counts[value]!! += record
        }

        return counts
    }

    private fun reduce(
        records: List<String>,
        position: Int,
        tieBreaker: Char,
        listSupplier: (Map<Char, List<String>>) -> List<String>
    ): Int {
        if (records.size == 1)
            return records[0].toInt(2)

        val counts = getCounts(records.iterator(), position)

        // Favour the highest character
        val next = if (allSameSize(counts)) counts[tieBreaker]!! else listSupplier.invoke(counts)

        return reduce(next, position + 1, tieBreaker, listSupplier)
    }

    private fun allSameSize(counts: Map<Char, List<String>>): Boolean {
        return counts.values.map { a -> a.size }.distinct().size == 1
    }
}
