package com.nohex.aoc.day12

const val START_NAME = "start"
const val END_NAME = "end"

class CaveMap(input: Sequence<String>) {
    val pathCount: Int
        get() = getPaths().count()

    private val caves: Set<Cave>

    init {
        // Use a dictionary at build time for speed.
        val tempPlaces = mutableMapOf<String, Cave>()
        // Each line in the input is a path between two vertices.
        for (line in input) {
            val (placeAName, placeBName) = line.split("-")
            // Retrieve or create the nodes.
            val caveA = tempPlaces[placeAName] ?: Cave(placeAName)
            val caveB = tempPlaces[placeBName] ?: Cave(placeBName)
            // Link both places.
            caveA.connectTo(caveB)
            // Make sure the new places are in the dictionary.
            tempPlaces[placeAName] = caveA
            tempPlaces[placeBName] = caveB
        }

        caves = tempPlaces.values.toSet()
    }

    /**
     * Get all paths from the start cave.
     */
    private fun getPaths(): List<Path> =
        caves.find { it.isStart }?.let {
            followPaths(it, Path(), mutableMapOf())
        } ?: emptyList()


    /**
     * Follows all paths
     */
    private fun followPaths(cave: Cave, path: Path, visitCounts: MutableMap<Cave, Int>): List<Path> {
        // Add the current place to the path.
        val currentPath = Path(path.places + cave)

        // When there are no more connections, return the path so far.
        if (cave.connections.isEmpty())
            return listOf(currentPath)

        // Otherwise, explore the connections.
        return cave.connections
            // Follow all visitable paths from this place.
            .filter { path.canVisit(cave) }
            // Create a new path for each connection.
            .flatMap { followPaths(it, currentPath, visitCounts) }
    }
}
