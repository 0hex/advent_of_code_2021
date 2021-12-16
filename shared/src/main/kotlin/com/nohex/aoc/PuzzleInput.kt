package com.nohex.aoc

import java.io.BufferedReader
import java.io.InputStream

/**
 * Encapsulates access to puzzle input stored as a file in the classpath.
 */
class PuzzleInput(path: String) {
    private val resource: InputStream

    init {
        resource = Thread.currentThread().contextClassLoader.getResourceAsStream(path)
            ?: throw IllegalArgumentException("Resource not available: $path")
    }

    /**
     * Returns a sequence with each line of the resource.
     */
    fun asSequence(): Sequence<String> {
        return resource.bufferedReader().lineSequence()
    }

    /**
     * Returns a string containing the whole resource.
     */
    fun asString(): String {
        return resource.bufferedReader().use(BufferedReader::readText)
    }
}
