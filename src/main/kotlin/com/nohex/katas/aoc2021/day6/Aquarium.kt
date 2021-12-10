package com.nohex.katas.aoc2021.day6

private const val NEW_TIMER = 8
private const val RESET_TIMER = 6
private const val SPENT_TIMER = 0

class Aquarium(initialTimers: List<Int>) {
    private var timers = mutableMapOf<Int, Int>()
    private var generation = 0

    init {
        // Create a map with counts for each timer.
        initialTimers.forEach { timers.merge(it, 1, Int::plus) }
    }

    fun after(days: Int): Int {
        while (generation < days) updateTimers()

        return timers.values.sum()
    }

    /**
     * Produces a new generation of fish.
     */
    private fun updateTimers() {
        // Create a new map for the update operation to be atomic.
        val newTimers = mutableMapOf<Int, Int>()
        // The rest of values see their timer decreased.
        for (timer in 1..NEW_TIMER) {
            // Move the current timer values to the next one.
            newTimers[timer - 1] = timers[timer] ?: 0
        }
        // As many 6s as there were 0s.
        newTimers[RESET_TIMER] = (newTimers[RESET_TIMER] ?: 0) + (timers[SPENT_TIMER] ?: 0)
        // As many 8s as there were 0s.
        newTimers[NEW_TIMER] = (newTimers[NEW_TIMER] ?: 0) + (timers[SPENT_TIMER] ?: 0)

        // Update the generation.
        generation++
        // Replace the timers.
        timers = newTimers
    }

}
