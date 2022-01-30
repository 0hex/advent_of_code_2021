package com.nohex.aoc.day16

sealed class OperatorPacket(
    version: Int,
    private val packets: List<Packet>,
    private val operation: (List<Long>) -> Long
) : Packet(version) {
    override fun versions(): List<Int> =
        listOf(version) + packets.flatMap { it.versions() }

    override fun value(): Long =
        operation(packets.map { it.value() })

    companion object {

        internal fun parseInput(input: Iterator<Char>): List<Packet> =
            // Take one character (the length type ID).
            when (input.next()) {
                // It's a 0, read as many characters as the next 15 bits.
                '0' -> findForLength(input)
                // It's a 1, read as many sub-packets as the next 11 bits.
                '1' -> findForCount(input)
                else -> error("Unexpected operator packet type")
            }

        /**
         *  Reads packets from the [input]'s fragment delimited by the number
         *  of characters in the first 15 bits.
         */
        private fun findForLength(input: Iterator<Char>): List<Packet> =
            input.next(15).toIntOrNull(radix = 2)?.let { length ->
                val subPacketIterator = input.next(length).iterator()
                val packets = mutableListOf<Packet>()
                while (subPacketIterator.hasNext()) {
                    packets += of(subPacketIterator)
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
