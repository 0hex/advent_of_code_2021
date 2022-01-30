package com.nohex.aoc.day16

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class EqualToPacketTest {
    private val sut = PacketGenerator.packetOfType(7)

    @Test
    fun `should have a version`() {
        sut.version shouldBe 1
    }

    @Test
    fun `should know its sub-packets' versions`() {
        sut.versions() shouldBe listOf(1, 2, 3)
    }

    @Test
    fun `its value should be 0 as the numbers are not equal`() {
        sut.value() shouldBe 0 // 17 != 8
    }
}
