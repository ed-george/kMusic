package uk.co.edgeorgedev.kmusic.data

import org.junit.Assert.*
import org.junit.Before
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

class PhraseTest {

    private lateinit var bar1: Bar
    private lateinit var bar2: Bar

    @Before
    fun setup() {
        bar1 = Bar()
        bar1.addNotes(
            Note(pitch = Pitch.A3),
            Rest(),
            // Expected highest note E4
            Chord(notes = arrayListOf(Note(pitch = Pitch.E4), Note(pitch = Pitch.C3)), duration = Duration.HALF_NOTE)
        )

        bar2 = Bar()
        bar2.addNotes(
            Note(pitch = Pitch.E3),
            Note(pitch = Pitch.F2), // Expected lowest note
            Note(pitch = Pitch.G3),
            Note(pitch = Pitch.C3)
        )
    }

    @Test
    fun `highest pitch is correct`() {
        val phrase = Phrase(bars = arrayListOf(bar1, bar2))
        assertEquals(Pitch.E4, phrase.highestPitch())
    }

    @Test
    fun `lowest pitch is correct`() {
        val phrase = Phrase(bars = arrayListOf(bar1, bar2))
        assertEquals(Pitch.F2, phrase.lowestPitch())
    }

    @Test
    fun `phrase with no bars has no highest pitch`() {
        val phrase = Phrase()
        assertNull(phrase.highestPitch())
    }

    @Test
    fun `phrase with no bars has no lowest pitch`() {
        val phrase = Phrase()
        assertNull(phrase.lowestPitch())
    }

    @Test
    fun `phrase with bars has correct stave`() {
        val phrase = Phrase(bars = arrayListOf(bar1, bar2))
        assertEquals(BassStave, phrase.stave)
    }

    @Test
    fun `phrase with no bars has unknown stave`() {
        val phrase = Phrase()
        assertEquals(UnknownStave, phrase.stave)
    }

    @Test
    fun `phrase with complete bars is complete`() {
        val phrase = Phrase(bars = arrayListOf(bar1, bar2))
        assertTrue(phrase.isPhraseComplete())
    }

    @Test
    fun `phrase with incomplete bars is incomplete`() {
        val bar3 = Bar()
        bar3.addNote(Note())

        val phrase = Phrase(bars = arrayListOf(bar1, bar2, bar3))
        assertFalse(phrase.isPhraseComplete())
    }

    @Test
    fun `phrase with no bars is incomplete`() {
        val phrase = Phrase()
        assertFalse(phrase.isPhraseComplete())
    }

}