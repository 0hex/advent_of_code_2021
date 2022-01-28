package com.nohex.aoc.day16

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class LiteralPacketTest {
    // 010  - Version 1
    // 100  - Type ID 4, literal packet
    // 1    - A 4-bit number follows, more numbers to come.
    // 1000 - Number 16
    // 0    - A 4-bit number follows, no more numbers to come.
    // 0001 - Number 1
    private val sut = Packet.of(
        "001 100 1 1000 0 0001"
            .replace(" ", "")// Remove guiding spaces
            .iterator()
    )

    @Test
    fun `should extract the numeric value`() {
        // 1000 0001 -> 0xF1 -> 129
        (sut as LiteralPacket).value shouldBe 129
    }
}
