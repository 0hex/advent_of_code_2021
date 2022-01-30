package com.nohex.aoc.day16


sealed class Packet(val version: Int) {
    abstract fun versions(): List<Int>
    abstract fun value(): Long

    companion object {
        fun of(input: Iterator<Char>): Packet {
            // Read the version's 3 bits.
            val version = input.next(3).toInt(radix = 2)
            // Read the type ID, 3 bits.
            val typeID = input.next(3).toInt(radix = 2)
            return when (typeID) {
                0 -> SumPacket.of(version, input)
                1 -> ProductPacket.of(version, input)
                2 -> MinimumPacket.of(version, input)
                3 -> MaximumPacket.of(version, input)
                4 -> LiteralPacket.of(version, input)
                5 -> GreaterThanPacket.of(version, input)
                6 -> LessThanPacket.of(version, input)
                7 -> EqualToPacket.of(version, input)
                else -> throw IllegalStateException("Unrecognised type ID")
            }
        }
    }
}
