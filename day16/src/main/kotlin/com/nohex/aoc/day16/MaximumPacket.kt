package com.nohex.aoc.day16

class MaximumPacket(version: Int, packets: List<Packet>) :
    OperatorPacket(version, packets, { values -> values.maxOf { it } }) {

    companion object {
        fun of(version: Int, input: Iterator<Char>) =
            MaximumPacket(version, parseInput(input))
    }
}
