package uk.co.edgeorgedev.kmusic.data

import org.junit.Assert.assertEquals
import org.junit.Test

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

class TimeSignatureTest {

    @Test(expected = IllegalArgumentException::class)
    fun `invalid time signature numerator`() {
        TimeSignature(-2, 4)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `invalid time signature denominator`() {
        TimeSignature(4, 3)
    }

    @Test
    fun `total beats in a bar 1`() {
        val timeSignature = TimeSignature(4, 4)
        assertEquals(4.0, timeSignature.totalBeatsPerBar(), 0.0)
    }

    @Test
    fun `total beats in a bar 2`() {
        val timeSignature = TimeSignature(6, 8)
        assertEquals(3.0, timeSignature.totalBeatsPerBar(), 0.0)
    }

    @Test
    fun `total beats in a bar 3`() {
        val timeSignature = TimeSignature(9, 8)
        assertEquals(4.5, timeSignature.totalBeatsPerBar(), 0.0)
    }

}