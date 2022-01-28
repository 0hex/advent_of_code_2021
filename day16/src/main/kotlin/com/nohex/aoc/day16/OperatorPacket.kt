package com.nohex.aoc.day16

class OperatorPacket(version: Int, private val packets: List<Packet>) : Packet(version) {
    override fun versions(): List<Int> =
        listOf(version) + packets.flatMap { it.versions() }

    companion object {

        fun of(version: Int, input: Iterator<Char>) =
            OperatorPacket(version, parseInput(input))

        private fun parseInput(input: Iterator<Char>): List<Packet> =
            // Take one character (the length type ID).
            when (input.next()) {
                // It's a 0, read as many characters as the next 15 bits.
                '0' -> findForLength(input)
                // It's a 1, read as many sub-packets as the next 11 bits.
                '1' -> findForCount(input)
                else -> error("Unexpected value")
            }

        /**
         *  Reads packets from the [input]'s fragment delimited by the number
         *  of characters in the first 15 bits.
         */
        private fun findForLength(input: Iterator<Char>): List<Packet> =
            input.next(15).toIntOrNull(radix = 2)?.let { length ->
                val inputIterator = input.next(length).iterator()
                val packets = mutableListOf<Packet>()
                while (inputIterator.hasNext()) {
                    packets += of(inputIterator)
                }
                packets
            } ?: emptyList()

        /** Reads as many packets from the [input] as specified in the first 11 bits. */
        private fun findForCount(input: Iterator<Char>): List<Packet> =
            input.next(11).toIntOrNull(radix = 2)?.let { packetCount ->
                (1..packetCount)
                    .map { of(input) }
                    .toList()
            } ?: emptyList()
    }
}
