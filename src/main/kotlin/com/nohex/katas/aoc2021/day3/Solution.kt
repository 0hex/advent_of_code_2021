package com.nohex.katas.aoc2021.day3

import com.nohex.katas.Resources

/**
 * Day 2 solution
 */

fun main() {
    println("Power consumption: " + Solution().getPowerConsumption(getInput()))
}

private fun getInput() =
    Resources.asLines("aoc2021/day3/input.txt")
        .filter(String::isNotBlank)

internal class Solution {


    fun getPowerConsumption(diagnostics: Sequence<String>): Int {
        val iterator = diagnostics.iterator();
        if (!iterator.hasNext()) {
            return 0;
        }

        // Obtain the record size from the first record.
        val record = iterator.next();
        val recordSize = record.length;
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
}
