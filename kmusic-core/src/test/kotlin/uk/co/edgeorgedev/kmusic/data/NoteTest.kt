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

class NoteTest {

    @Test
    fun `note creation`() {
        val note = Note(Pitch.A3, Duration.DEMI_SEMI_QUAVER)
        assertEquals(Pitch.A3, note.pitch)
        assertEquals(Duration.DEMI_SEMI_QUAVER, note.duration)
    }

    @Test
    fun `note equality`() {
        val note1 = Note(Pitch.E5, Duration.SIXTEENTH_NOTE)
        val note2 = Note(Pitch.E5, Duration.SIXTEENTH_NOTE)
        assertEquals(note1, note2)
    }

}