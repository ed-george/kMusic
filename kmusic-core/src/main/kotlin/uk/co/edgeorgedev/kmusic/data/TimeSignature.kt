package uk.co.edgeorgedev.kmusic.data

import uk.co.edgeorgedev.kmusic.util.isPow2

/*
 * kMusic - A modern music library for Kotlin
 * Copyright (C) 2019 Ed George
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>
 */

/**
 * Representation of a time signature to specify how many beats are contained in each measure (bar)
 * @property numerator the indicator of how many beats constitute a bar; Must be a positive integer; Defaults to 4
 * @property denominator the note value that represents one beat; Must be a positive power of two; Defaults to 4
 */
class TimeSignature(numerator: Int = 4, denominator: Int = 4) {
    val numerator = if (numerator > 0) numerator
    else throw IllegalArgumentException("Numerator must be positive")
    val denominator = if (denominator > 0 && denominator.isPow2()) denominator
    else throw IllegalArgumentException("Numerator must be a positive power of 2")

    companion object {
        /**
         * Common time
         */
        val FOUR_FOUR = TimeSignature()
        /**
         * Waltz time
         */
        val THREE_FOUR = TimeSignature(3, 4)
        /**
         * Polka time
         */
        val SIX_EIGHT = TimeSignature(6, 8)
    }

    /**
     * Get the total number of beats per bar for the given time signature
     */
    fun totalBeatsPerBar(): Double = numerator * (4.0/denominator)

    override fun toString(): String {
        return "$numerator/$denominator"
    }
}