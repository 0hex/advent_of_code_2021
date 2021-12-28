package com.nohex.aoc.day13

import com.nohex.aoc.Point
import com.nohex.aoc.day13.FoldInstruction.Direction.LEFT
import com.nohex.aoc.day13.FoldInstruction.Direction.UP
import kotlin.math.max

val LOCATION_PATTERN = """(\d+),(\d+)""".toRegex()
val FOLD_PATTERN = """fold along ([xy])=(\d+)""".toRegex()

class MapData(input: Sequence<String>) {
    val width: Int
    val height: Int
    val dots: Set<Point>
    val instructions: List<FoldInstruction>

    init {
        var maxX = 0
        var maxY = 0
        val tempPoints = mutableSetOf<Point>()
        val tempInstructions = mutableListOf<FoldInstruction>()

        input.forEach {
            // Is it a location?
            LOCATION_PATTERN.matchEntire(it)
                ?.destructured
                ?.let { (column, row) ->
                    tempPoints += Point(column.toInt(), row.toInt())
                        .also { point ->
                            // Update the map's dimensions.
                            maxX = max(maxX, point.x)
                            maxY = max(maxY, point.y)
                        }
                }

            // Is it a fold instruction?
            FOLD_PATTERN.matchEntire(it)
                ?.destructured
                ?.let { (direction, amount) ->
                    tempInstructions += when (direction) {
                        "x" -> FoldInstruction(LEFT, amount.toInt())
                        "y" -> FoldInstruction(UP, amount.toInt())
                        else -> throw IllegalArgumentException("Unknown fold direction")
                    }
                }
        }

        width = maxX + 1
        height = maxY + 1
        dots = tempPoints
        instructions = tempInstructions
    }
}
