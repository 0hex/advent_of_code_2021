package com.nohex.katas.aoc2021.day1

internal class Solution {
    /**
     * Counts the number of consecutive increases in the provided measurements.
     *
     * @param measurements A sequence of measurements to be compared.
     */
    fun count(measurements: Sequence<Int>): Int {
        val iterator = measurements.iterator()
        // If no elements, the count is 0.
        if (!iterator.hasNext()) return 0

        // Holds the count of consecutive increases.
        var count = 0
        // Get the first value.
        var previous = iterator.next()
        while (iterator.hasNext()) {
            // Get the next value in the sequence
            val current = iterator.next()
            // If the current value has increased since the last one, count it.
            if (current > previous)
                count++
            previous = current
        }

        return count
    }

    /**
     * Counts the number of consecutive increases in the provided measurements.
     *
     * @param measurements A sequence of measurements to be compared.
     */
    fun countWindows(measurements: Sequence<Int>): Int {
        val iterator = measurements.windowed(3).iterator()
        // If no elements, the count is 0.
        if (!iterator.hasNext()) return 0

        // Holds the count of consecutive increases.
        var count = 0
        // Get the first value.
        var previousWindowSum = iterator.next().sum()
        while (iterator.hasNext()) {
            // Get the next value in the sequence
            val currentWindowSum = iterator.next().sum()
            // If the current value has increased since the last one, count it.
            if (currentWindowSum > previousWindowSum)
                count++
            previousWindowSum = currentWindowSum
        }

        return count
    }
}
