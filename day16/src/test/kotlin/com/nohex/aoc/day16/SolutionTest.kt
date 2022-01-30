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
            .toBinary()
            .joinToString("")

        binaryString shouldBe expectedBinaryString
    }

    @ParameterizedTest(name = "version sum for {0} should be {1}")
    @ArgumentsSource(VersionTestPackets::class)
    fun calculateVersionSum(hexValue: String, versionSum: Int) {
        hexValue.asSequence().toBinary().iterator().let {
            Packet.of(it)
                .versions()
                .sum() shouldBe versionSum
        }
    }

    class VersionTestPackets : ArgumentsProvider {
        override fun provideArguments(p0: ExtensionContext?): Stream<out Arguments> =
            Stream.of(
                Arguments.of("8A004A801A8002F478", 16),
                Arguments.of("620080001611562C8802118E34", 12),
                Arguments.of("C0015000016115A2E0802F182340", 23),
                Arguments.of("A0016C880162017C3686B18A3D4780", 31)
            )

    }

    @ParameterizedTest(name = "value calculation for {0} should be {1}")
    @ArgumentsSource(ValueTestPackets::class)
    fun calculateValue(hexValue: String, value: Int) {
        hexValue.asSequence().toBinary().iterator().let {
            Packet.of(it).value() shouldBe value
        }
    }

    class ValueTestPackets : ArgumentsProvider {
        override fun provideArguments(p0: ExtensionContext?): Stream<out Arguments> =
            Stream.of(
                Arguments.of("C200B40A82", 3),
                Arguments.of("04005AC33890", 54),
                Arguments.of("880086C3E88112", 7),
                Arguments.of("CE00C43D881120", 9),
                Arguments.of("D8005AC2A8F0", 1),
                Arguments.of("F600BC2D8F", 0),
                Arguments.of("9C005AC2F8F0", 0),
                Arguments.of("9C0141080250320F1802104A08", 1),
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
