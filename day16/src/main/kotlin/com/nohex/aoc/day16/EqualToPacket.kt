package com.nohex.aoc.day16

class EqualToPacket(version: Int, packets: List<Packet>) :
    OperatorPacket(version, packets, { values -> if (values.all { it == values[0] }) 1 else 0 }) {

    companion object {
        fun of(version: Int, input: Iterator<Char>) =
            EqualToPacket(version, parseInput(input))
    }
}

