package com.nohex.aoc.day16

class SumPacket(version: Int, packets: List<Packet>) :
    OperatorPacket(version, packets, List<Long>::sum) {

    companion object {
        fun of(version: Int, input: Iterator<Char>) =
            SumPacket(version, parseInput(input))
    }
}
