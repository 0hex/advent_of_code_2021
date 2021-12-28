package com.nohex.aoc.day13

import com.nohex.aoc.Point
import com.nohex.aoc.day13.FoldInstruction.Direction.LEFT
import com.nohex.aoc.day13.FoldInstruction.Direction.UP

class FoldingMap(initialDotLocations: Set<Point>) {
    private var dots = initialDotLocations
    val dotCount
        get() = dots.count()

    /**
     * Fold the map alongside the edge specified in the [instruction].
     */
    fun fold(instruction: FoldInstruction) {
        // Relocate each affected dot according to the instruction.
        dots = dots.map {
            if (instruction.direction == UP && (it.y > instruction.amount)) {
                // If the dot is below the folding line, relocate.
                Point(it.x, it.y - 2 * (it.y - instruction.amount))
            } else if (instruction.direction == LEFT && (it.x > instruction.amount)) {
                // If the dot is to the right of the folding line, relocate.
                Point(it.x - 2 * (it.x - instruction.amount), it.y)
            } else {
                it
            }
        }.toSet()
    }
}
