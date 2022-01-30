package com.nohex.aoc.day16

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class GreaterThanPacketTest {
    private val sut = PacketGenerator.packetOfType(5)

    @Test
    fun `should have a version`() {
        sut.version shouldBe 1
    }

    @Test
    fun `should know its sub-packets' versions`() {
        sut.versions() shouldBe listOf(1, 2, 3)
    }

    @Test
    fun `its value should be 1 since 11 is greater than 8`() {
        sut.value() shouldBe 1 // 17 > 8
    }
}
