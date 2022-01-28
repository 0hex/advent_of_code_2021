package com.nohex.aoc.day16

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class SolutionTest {

    @Test
    fun `should convert hex to binary`() {
        val hexValue = "0123456789ABCDEF"
        val expectedBinaryString = "0000000100100011010001010110011110001001101010111100110111101111"

        val binaryString = hexValue.asSequence()
            .toBCD()
            .joinToString("")

        binaryString shouldBe expectedBinaryString
    }

    @ParameterizedTest(name = "version sum for {0} should be {1}")
    @ArgumentsSource(TestPackets::class)
    fun calculateVersionSum(hexValue: String, versionSum: Int) {
        hexValue.asSequence().toBCD().iterator().let {
            Packet.of(it)
                .versions()
                .sum() shouldBe versionSum
        }
    }

    class TestPackets : ArgumentsProvider {
        override fun provideArguments(p0: ExtensionContext?): Stream<out Arguments> =
            Stream.of(
                Arguments.of("8A004A801A8002F478", 16),
                Arguments.of("620080001611562C8802118E34", 12),
                Arguments.of("C0015000016115A2E0802F182340", 23),
                Arguments.of("A0016C880162017C3686B18A3D4780", 31)
            )

    }

// 8A004A801A8002F478 ->
// 100
// 010
// 1
// 00000000001
// -- Sub-packet 1
// 001
// 010
// 1
// 00000000001
    // -- Sub-packet 1.1
// 101
// 010
// 0
// 000000000001011
    // -- Sub-packet 1.1.1
// 110
// 100
// 01111
// 000
}
