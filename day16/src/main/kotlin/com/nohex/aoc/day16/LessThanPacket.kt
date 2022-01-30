package com.nohex.aoc.day16

class LessThanPacket(version: Int, packets: List<Packet>) :
    OperatorPacket(
        version,
        packets,
        { values -> if (values.first() < values.last()) 1 else 0 }) {

    companion object {
        fun of(version: Int, input: Iterator<Char>) =
            LessThanPacket(version, parseInput(input))
    }
}

