package com.nohex.aoc.day16

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class OperatorPacketTest {
    // 001 - Version 1
    // 000 - Type ID 0
    // 1 - Parse sub-packets by count
    // 00000000010 - 11 bits for sub-packet count (1 sub-packet)
    // -- Start of sub-packet
    // 010 - Version 2
    // 100 - Type ID 4, literal packet
    // 10001 - Number 1, more to come
    // 00001 - Number 1, no more to come
    // -- Start of 2nd sub-packet
    // 011 - Version 3
    // 100 - Type ID 4, literal packet
    // 01000 - Number 16, no more to come
    // ---
    // 000 - Padding
    private val sut = Packet.of(
        "001 000 1 00000000010 010 100 10001 00001 011 100 01000 000"
            .replace(" ", "")// Remove guiding spaces
            .iterator()
    )

    @Test
    fun `should have a version`() {
        sut.version shouldBe 1
    }

    @Test
    fun `should know its sub-packets' versions`() {
        sut.versions() shouldBe listOf(1, 2, 3)
    }
}
