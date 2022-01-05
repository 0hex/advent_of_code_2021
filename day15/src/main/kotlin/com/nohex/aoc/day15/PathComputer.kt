package com.nohex.aoc.day15

import com.nohex.aoc.Matrix
import com.nohex.aoc.Point
import org.slf4j.LoggerFactory
import java.util.*

val neighbourLocations = setOf(
    Point(0, -1), // North
    Point(1, 0), // West
    Point(-1, 0),// East
    Point(0, 1) // South
)

/**
 *  The [risk] involved in arriving at the location specified by [to].
 */
class Path(val to: Point, val risk: Int) : Comparable<Path> {
    // Less risk goes first.
    override fun compareTo(other: Path): Int =
        this.risk.compareTo(other.risk)

    override fun toString() = "<$risk to ${to.x},${to.y}>"
}

class PathComputer(private val riskMatrix: Matrix) {
    companion object {
        @Suppress("JAVA_CLASS_ON_COMPANION")
        @JvmStatic
        private val logger = LoggerFactory.getLogger(javaClass.enclosingClass)
    }

    var lowestRisk: Int? = null
        private set

    private val startLocation = Point(0, 0)
    private val endLocation = riskMatrix.end

    init {
        lowestRisk = calculateLowestRisk()
    }

    /**
     * Calculates the lowest risk found for any paths that start in the top-left corner and end in the bottom-right corner.
     */
    private fun calculateLowestRisk(): Int {
        // A priority queue sorted by risk.
        val pathsToExplore = PriorityQueue<Path>().apply { add(Path(startLocation, 0)) }
        val visited = mutableListOf<Point>()

        while (pathsToExplore.isNotEmpty()) {
            pathsToExplore.poll()?.let { path ->
                // If the end has been reached, return the total risk.
                val location = path.to
                logger.debug("Checking $location...")

                if (location == endLocation) {
                    logger.debug("Found the end ${path.to} at risk ${path.risk}")
                    return path.risk
                }

                // If not yet visited, explore neighbours.
                if (location !in visited) {
                    visited += location
                    logger.info("Exploring $location...")
                    neighbourLocations
                        .map { location.transform(it) }
                        .filter { it !in visited }
                        .forEach {
                            riskMatrix[it]?.let { neighbourRisk ->
                                logger.debug("Scheduling $it for ${path.risk + neighbourRisk}")
                                pathsToExplore.offer(Path(it, path.risk + neighbourRisk))
                            }
                        }
                }
            }

            logger.info("${pathsToExplore.size} locations to check")
            logger.debug("$pathsToExplore")
        }

        error("No minimum risk was found")
    }
}
