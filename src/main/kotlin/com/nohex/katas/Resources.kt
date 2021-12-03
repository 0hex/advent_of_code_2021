package com.nohex.katas

import java.io.InputStream

class Resources {
    companion object Functions {
        /**
         * Read a file from the resources.
         *
         * @param path The path of the resource.
         * @return A sequence with each line of the specified file.
         */
        fun asLines(path: String): Sequence<String> {
            val resource: InputStream = Thread.currentThread().contextClassLoader.getResourceAsStream(path)
                ?: throw IllegalArgumentException("Resource not available: $path")

            return resource.bufferedReader().lineSequence()
        }
    }
}
