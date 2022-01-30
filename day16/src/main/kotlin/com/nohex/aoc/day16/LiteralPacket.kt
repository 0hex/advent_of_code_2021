package com.nohex.aoc.day16


class LiteralPacket(version: Int, val value: Long) : Packet(version) {
    override fun versions(): List<Int> =
        listOf(version)

    override fun value(): Long = value

    companion object {

        fun of(version: Int, input: Iterator<Char>) =
            LiteralPacket(version, readValue(input))

        private fun readValue(input: Iterator<Char>): Long =
            with(StringBuilder()) {
                // Build the value by taking groups of four bits.
                var moreRecords: Boolean
                do {
                    moreRecords = input.next(1) == "1"
                    append(input.next(4))
                } while (moreRecords)
                // Create the string.
                toString()
            }
                .asSequence()
                .joinToString("")
                .toLong(radix = 2)
    }
}
