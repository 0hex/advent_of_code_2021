package com.nohex.aoc.day16

class MinimumPacket(version: Int, packets: List<Packet>) :
    OperatorPacket(version, packets, { values -> values.minOf { it } }) {

    companion object {
        fun of(version: Int, input: Iterator<Char>) =
            MinimumPacket(version, parseInput(input))
    }
}
