package com.nohex.aoc.day16


sealed class Packet(val version: Int) {
    abstract fun versions(): List<Int>

    companion object {
        fun of(input: Iterator<Char>): Packet {
            // Read the version's 3 bits.
            val version = input.next(3).toInt(radix = 2)
            // Read the type ID, 3 bits.
            val typeID = input.next(3).toInt(radix = 2)
            return when (typeID) {
                4 -> LiteralPacket.of(version, input)
                else -> OperatorPacket.of(version, input)
            }
        }
    }
}
