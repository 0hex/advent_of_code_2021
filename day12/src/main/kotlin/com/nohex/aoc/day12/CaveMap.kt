package com.nohex.aoc.day12

const val START_NAME = "start"
const val END_NAME = "end"

class CaveMap(input: Sequence<String>) {
    val pathCount: Int
        get() = getPaths { path, cave -> path.canVisit(cave) }.count()
    val longPathCount: Int
        get() = getPaths { path, cave -> path.canVisitTwice(cave) }.count()

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
    private fun getPaths(visitableCondition: (Path, Cave) -> Boolean): List<Path> =
        caves.find { it.isStart }?.let {
            followPaths(it, Path(), visitableCondition)
        } ?: emptyList()


    /**
     * Returns a list of all paths to [cave]'s connections.
     */
    private fun followPaths(
        cave: Cave,
        path: Path,
        visitableCondition: (Path, Cave) -> Boolean
    ): List<Path> {
        // Add the current place to the path.
        val currentPath = Path(path.caves + cave)

        // When there are no more connections, return the path so far.
        if (cave.connections.isEmpty())
            return listOf(currentPath)

        // Otherwise, explore the connections.
        return cave.connections
            // Follow all visitable paths from this place.
            .filter { visitableCondition(path, cave) }
            // Create a new path for each connection.
            .flatMap { followPaths(it, currentPath, visitableCondition) }
    }
}
