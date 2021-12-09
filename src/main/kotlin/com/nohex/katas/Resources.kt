package com.nohex.katas

import java.io.InputStream

class Resources {
    companion object Functions {
        /**
         * Returns a sequence with each line of the resource in the given [path].
         */
        fun asLines(path: String): Sequence<String> {
            val resource: InputStream = Thread.currentThread().contextClassLoader.getResourceAsStream(path)
                ?: throw IllegalArgumentException("Resource not available: $path")

            return resource.bufferedReader().lineSequence()
        }
    }
}
