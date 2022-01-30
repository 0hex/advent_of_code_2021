package com.nohex.aoc.day16

private fun Iterable<Long>.product(): Long = this.reduce { acc, it -> acc * it }

class ProductPacket(version: Int, packets: List<Packet>) :
    OperatorPacket(version, packets, List<Long>::product) {

    companion object {
        fun of(version: Int, input: Iterator<Char>) =
            ProductPacket(version, parseInput(input))
    }
}
