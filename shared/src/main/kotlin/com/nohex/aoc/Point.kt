package com.nohex.aoc

/** A point in a two-dimension space */
class Point(val x: Int, val y: Int) {
    /**
     * Returns a new point whose coordinates are translated applying the
     * [delta] point's coordinates as relative translations.
     */
    fun transform(delta: Point): Point =
        Point(x + delta.x, y + delta.y)

    override fun toString(): String {
        return "Point($x, $y)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Point

        if (x != other.x) return false
        if (y != other.y) return false

        return true
    }

    override fun hashCode(): Int {
        var result = x
        result = 31 * result + y
        return result
    }
}