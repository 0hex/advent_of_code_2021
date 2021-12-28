package com.nohex.aoc.day13

/**
 * Instruction to fold a map [amount] units alongside the specified [direction].
 */
data class FoldInstruction(val direction: Direction, val amount: Int) {
    enum class Direction {
        UP,
        LEFT
    }
}
