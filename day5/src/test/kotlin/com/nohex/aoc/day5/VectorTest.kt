package com.nohex.aoc.day5

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.sequences.shouldContainAll
import io.kotest.matchers.shouldBe

internal class VectorTest : StringSpec({
    "straight vectors" {
        Vector(Point(1, 2), Point(1, 3)).isStraight shouldBe true
        Vector(Point(3, 1), Point(6, 1)).isStraight shouldBe true
        Vector(Point(9, 6), Point(3, 6)).isStraight shouldBe true
        Vector(Point(3, 8), Point(3, 5)).isStraight shouldBe true
        Vector(Point(1, 3), Point(3, 1)).isStraight shouldBe false
    }

    "diagonal vectors" {
        Vector(Point(2, 3), Point(7, 8)).isDiagonal shouldBe true
        Vector(Point(5, 9), Point(9, 5)).isDiagonal shouldBe true
        Vector(Point(2, 1), Point(1, 2)).isDiagonal shouldBe true
        Vector(Point(3, 8), Point(3, 5)).isDiagonal shouldBe false
    }

    "north vector" {
        val sut = Vector(Point(0, 3), Point(0, 0))
        sut.isStraight shouldBe true
        sut.isDiagonal shouldBe false
        sut.points shouldContainAll setOf(
            Point(0, 0),
            Point(0, 1),
            Point(0, 2),
            Point(0, 3),
        )
    }

    "south vector" {
        val sut = Vector(Point(3, 0), Point(3, 2))
        sut.isStraight shouldBe true
        sut.isDiagonal shouldBe false
        sut.points shouldContainAll setOf(
            Point(3, 0),
            Point(3, 1),
            Point(3, 2),
        )
    }

    "east vector" {
        val sut = Vector(Point(1, 0), Point(3, 0))
        sut.isStraight shouldBe true
        sut.isDiagonal shouldBe false
        sut.points shouldContainAll setOf(
            Point(1, 0),
            Point(2, 0),
            Point(3, 0),
        )
    }

    "west vector" {
        val sut = Vector(Point(3, 2), Point(1, 2))
        sut.isStraight shouldBe true
        sut.isDiagonal shouldBe false
        sut.points shouldContainAll setOf(
            Point(1, 2),
            Point(2, 2),
            Point(3, 2),
        )
    }

    "northwest vector" {
        val sut = Vector(Point(3, 4), Point(1, 2))
        sut.isStraight shouldBe false
        sut.isDiagonal shouldBe true
        sut.points shouldContainAll setOf(
            Point(3, 4),
            Point(2, 3),
            Point(1, 2),
        )
    }

    "northeast vector" {
        val sut = Vector(Point(1, 4), Point(3, 2))
        sut.isStraight shouldBe false
        sut.isDiagonal shouldBe true
        sut.points shouldContainAll setOf(
            Point(1, 4),
            Point(2, 3),
            Point(3, 2),
        )
    }

    "southeast vector" {
        val sut = Vector(Point(1, 2), Point(3, 4))
        sut.isStraight shouldBe false
        sut.isDiagonal shouldBe true
        sut.points shouldContainAll setOf(
            Point(1, 2),
            Point(2, 3),
            Point(3, 4),
        )
    }

    "southwest vector" {
        val sut = Vector(Point(3, 2), Point(1, 4))
        sut.isStraight shouldBe false
        sut.isDiagonal shouldBe true
        sut.points shouldContainAll setOf(
            Point(3, 2),
            Point(2, 3),
            Point(1, 4),
        )
    }
})
