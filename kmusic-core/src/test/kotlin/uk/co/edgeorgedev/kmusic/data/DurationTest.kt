package uk.co.edgeorgedev.kmusic.data

import org.junit.Assert.*
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

class DurationTest {

    @Test
    fun `whole note modern and traditional durations are equal`() {
        assertEquals(Duration.SEMIBREVE.value, Duration.WHOLE_NOTE.value, 0.0)
    }

    @Test
    fun `half note modern and traditional durations are equal`() {
        assertEquals(Duration.MINIM.value, Duration.HALF_NOTE.value, 0.0)
    }

    @Test
    fun `quarter note modern and traditional durations are equal`() {
        assertEquals(Duration.CROTCHET.value, Duration.QUARTER_NOTE.value, 0.0)
    }

    @Test
    fun `eighth note modern and traditional durations are equal`() {
        assertEquals(Duration.QUAVER.value, Duration.EIGHTH_NOTE.value, 0.0)
    }

    @Test
    fun `sixteenth note modern and traditional durations are equal`() {
        assertEquals(Duration.SEMI_QUAVER.value, Duration.SIXTEENTH_NOTE.value, 0.0)
    }

    @Test
    fun `thirtysecond note modern and traditional durations are equal`() {
        assertEquals(Duration.DEMI_SEMI_QUAVER.value, Duration.THIRTYSECOND_NOTE.value, 0.0)
    }

}