package uk.co.edgeorgedev.kmusic.data

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
 * Representation of Tempo
 * @property value the value of the tempo in bpm; Must be positive and non-zero
 */
class Tempo(value: Int) {
    val value = if (value > 0) value else throw IllegalArgumentException("Tempo must be greater than 0")
    /**
     * Get BPM for current tempo
     */
    fun beatsPerMinute() = value
    /**
     * Get BPS for current tempo
     */
    fun beatsPerSecond() = 60.0 / value

    companion object {
        /**
         * Default tempo - 120 BPM
         */
        val DEFAULT = Tempo(120)
    }
}