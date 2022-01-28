package com.nohex.aoc.day16

import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class PacketTest {
    @Test
    fun testFactoryMethod() {
        val sut = Packet.of("0011001000101000".iterator())
        sut.version shouldBe 1
        sut.should { it is LiteralPacket }
    }
}
