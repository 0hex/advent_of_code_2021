package com.nohex.aoc.day16

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class ProductPacketTest {
    private val sut = PacketGenerator.packetOfType(1)

    @Test
    fun `should have a version`() {
        sut.version shouldBe 1
    }

    @Test
    fun `should know its sub-packets' versions`() {
        sut.versions() shouldBe listOf(1, 2, 3)
    }

    @Test
    fun `its value should be the product of the values of its sub-packets`() {
        sut.value() shouldBe 136 // 17 x 8
    }
}
