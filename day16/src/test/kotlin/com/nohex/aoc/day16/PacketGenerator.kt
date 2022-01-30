package com.nohex.aoc.day16

class PacketGenerator {
    companion object {
        /**
         * Creates an encoded packet for the requested [typeID].
         */
        fun packetOfType(typeID: Int): Packet {
            val typeIDString = when (typeID) {
                0 -> "000" // Sum
                1 -> "001" // Product
                2 -> "010" // Minimum
                3 -> "011" // Maximum
                4 -> "100" // Literal
                5 -> "101" // Greater than
                6 -> "110" // Less than
                7 -> "111" // Equal to
                else -> error("Unrecognised type ID")
            }

            // 001 - Version 1
            // xxx - Type ID 1 (product)
            // 1 - Parse sub-packets by count
            // 00000000010 - 11 bits for sub-packet count (2 sub-packets)
            // -- Start of sub-packet
            // 010 - Version 2
            // 100 - Type ID 4, literal packet
            // 10001 - Number 1, more to come
            // 00001 - Number 1, no more to come
            // -- Start of 2nd sub-packet
            // 011 - Version 3
            // 100 - Type ID 4, literal packet
            // 01000 - Number 8, no more to come
            // ---
            // 000 - Padding
            return Packet.of(
                "001 $typeIDString 1 00000000010 010 100 10001 00001 011 100 01000 000"
                    .replace(" ", "")// Remove guiding spaces
                    .iterator()
            )

        }
    }
}
