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

    @Test
    fun `rest creation`() {
        val rest = Rest(Duration.DEMI_SEMI_QUAVER)
        assertEquals(Duration.DEMI_SEMI_QUAVER, rest.duration)
    }

    @Test
    fun `rest equality`() {
        val rest1 = Rest(Duration.SIXTEENTH_NOTE)
        val rest2 = Rest(Duration.SIXTEENTH_NOTE)
        assertEquals(rest1, rest2)
    }

    @Test
    fun `chord creation`() {
        val chord = Chord(duration = Duration.HALF_NOTE, notes = arrayListOf(Note(pitch = Pitch.A3), Note(pitch = Pitch.C3)))
        assertEquals(listOf(Note(pitch = Pitch.A3), Note(pitch = Pitch.C3)), chord.notes)
        assertEquals(Duration.HALF_NOTE, chord.duration)
    }

    @Test
    fun `chord equality`() {
        val chord1 = Chord(duration = Duration.HALF_NOTE, notes = arrayListOf(Note(pitch = Pitch.A3), Note(pitch = Pitch.C3)))
        val chord2 = Chord(duration = Duration.HALF_NOTE, notes = arrayListOf(Note(pitch = Pitch.A3), Note(pitch = Pitch.C3)))
        assertEquals(chord1, chord2)
    }

}