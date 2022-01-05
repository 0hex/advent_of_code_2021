package com.nohex.aoc

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.collections.shouldContainExactlyInAnyOrder
import io.kotest.matchers.shouldBe

private class NavigableChar(val value: Char) : DefaultNavigableItem() {
    override fun toString(): String = "$value"
}

class NavigableItemSetTest : ShouldSpec({
    context("A given string sequence representing a 3x3 matrix of characters") {
        val input = """
            123
            456
            789
        """.trimIndent()
        val sut = NavigableItemSet<NavigableChar>(
            setOf(
                Point(0, -1), // North
                Point(-1, 0), // West
                Point(1, 0), // East
                Point(0, 1), // South
            )
        )
        val navigableItems = sut.load(input.lineSequence()) { _, it -> NavigableChar(it) }

        should("end up with 5 at its center, having 4 neighbours") {
            navigableItems[Point(1, 1)]?.let {
                it.value shouldBe '5'
                it.neighbours
                    .filterIsInstance<NavigableChar>()
                    .map { neighbour -> neighbour.value } shouldContainExactlyInAnyOrder setOf('2', '4', '6', '8')
            }
        }
        should("end up with 1 at its top left, having 2 neighbours") {
            navigableItems[Point(0, 0)]?.let {
                it.value shouldBe '1'
                it.neighbours
                    .filterIsInstance<NavigableChar>()
                    .map { neighbour -> neighbour.value } shouldContainExactlyInAnyOrder setOf('2', '4')
            }
        }
    }
})