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

class BarTest {

    @Test
    fun `empty bar has no beats`() {
        val bar = Bar()
        assertEquals(0.0, bar.totalBeatsInBar(), 0.0)
    }

    @Test
    fun `bar with notes has correct total beats`() {
        val bar = Bar().apply {
            addNotes(
                Note(duration = Duration.EIGHTH_NOTE),
                Note(duration = Duration.SIXTEENTH_NOTE),
                Note(duration = Duration.SIXTEENTH_NOTE),
                Note(duration = Duration.QUARTER_NOTE),
                Note(duration = Duration.HALF_NOTE)
            )
        }
        assertEquals(4.0, bar.totalBeatsInBar(), 0.0)
    }

    @Test
    fun `bar with rests has correct total beats`() {
        val bar = Bar().apply {
            addNotes(
                Rest(duration = Duration.EIGHTH_NOTE),
                Rest(duration = Duration.SIXTEENTH_NOTE),
                Rest(duration = Duration.SIXTEENTH_NOTE),
                Rest(duration = Duration.QUARTER_NOTE),
                Rest(duration = Duration.HALF_NOTE)
            )
        }
        assertEquals(4.0, bar.totalBeatsInBar(), 0.0)
    }

    @Test
    fun `bar with chords has correct total beats`() {
        val bar = Bar().apply {
            addNotes(
                Chord(duration = Duration.EIGHTH_NOTE, notes = arrayListOf(Note(pitch = Pitch.A3), Note(pitch = Pitch.C3))),
                Chord(duration = Duration.SIXTEENTH_NOTE, notes = arrayListOf(Note(pitch = Pitch.A3), Note(pitch = Pitch.C3))),
                Chord(duration = Duration.SIXTEENTH_NOTE, notes = arrayListOf(Note(pitch = Pitch.A3), Note(pitch = Pitch.C3))),
                Chord(duration = Duration.QUARTER_NOTE, notes = arrayListOf(Note(pitch = Pitch.A3), Note(pitch = Pitch.C3))),
                Chord(duration = Duration.HALF_NOTE, notes = arrayListOf(Note(pitch = Pitch.A3), Note(pitch = Pitch.C3)))
            )
        }
        assertEquals(4.0, bar.totalBeatsInBar(), 0.0)
    }

    @Test
    fun `complex bar with notes has correct total beats`() {
        val bar = Bar().apply {
            addNotes(
                Note(duration = Duration.SIXTEENTH_NOTE),
                Note(duration = Duration.SIXTEENTH_NOTE),
                Note(duration = Duration.EIGHTH_NOTE),
                Note(duration = Duration.SIXTEENTH_NOTE),
                Note(duration = Duration.THIRTYSECOND_NOTE),
                Note(duration = Duration.THIRTYSECOND_NOTE),
                Note(duration = Duration.SIXTEENTH_NOTE),
                Note(duration = Duration.SIXTEENTH_NOTE),
                Note(duration = Duration.EIGHTH_NOTE),
                Note(duration = Duration.SIXTEENTH_NOTE),
                Note(duration = Duration.THIRTYSECOND_NOTE),
                Note(duration = Duration.THIRTYSECOND_NOTE),
                Note(duration = Duration.SIXTEENTH_NOTE),
                Note(duration = Duration.SIXTEENTH_NOTE),
                Note(duration = Duration.EIGHTH_NOTE),
                Note(duration = Duration.SIXTEENTH_NOTE),
                Note(duration = Duration.THIRTYSECOND_NOTE),
                Note(duration = Duration.THIRTYSECOND_NOTE)
            )
        }
        assertEquals(4.5, bar.totalBeatsInBar(), 0.0)
    }

    @Test
    fun `empty bar is incomplete`() {
        val bar = Bar()
        assertFalse(bar.isBarComplete(TimeSignature.FOUR_FOUR))
    }

    @Test
    fun `complete bar with note is complete`() {
        val bar = Bar().apply {
            addNote(Note(duration = Duration.WHOLE_NOTE))
        }
        assertTrue(bar.isBarComplete(TimeSignature.FOUR_FOUR))
    }

    @Test
    fun `complete bar with rest is complete`() {
        val bar = Bar().apply {
            addNote(Rest(duration = Duration.WHOLE_NOTE))
        }
        assertTrue(bar.isBarComplete(TimeSignature.FOUR_FOUR))
    }

    @Test
    fun `complete bar with chord is complete`() {
        val bar = Bar().apply {
            addNote(Chord(duration = Duration.WHOLE_NOTE, notes = arrayListOf(Note(pitch = Pitch.A6), Note(pitch = Pitch.C6))))
        }
        assertTrue(bar.isBarComplete(TimeSignature.FOUR_FOUR))
    }


    @Test
    fun `complete complex bar is complete`() {
        val bar = Bar().apply {
            addNotes(
                Note(duration = Duration.SIXTEENTH_NOTE),
                Note(duration = Duration.SIXTEENTH_NOTE),
                Rest(duration = Duration.EIGHTH_NOTE),
                Note(duration = Duration.SIXTEENTH_NOTE),
                Note(duration = Duration.THIRTYSECOND_NOTE),
                Note(duration = Duration.THIRTYSECOND_NOTE),
                Note(duration = Duration.SIXTEENTH_NOTE),
                Rest(duration = Duration.SIXTEENTH_NOTE),
                Note(duration = Duration.EIGHTH_NOTE),
                Note(duration = Duration.SIXTEENTH_NOTE),
                Note(duration = Duration.THIRTYSECOND_NOTE),
                Chord(duration = Duration.THIRTYSECOND_NOTE, notes = arrayListOf(Note(pitch = Pitch.A3), Note(pitch = Pitch.C3))),
                Note(duration = Duration.SIXTEENTH_NOTE),
                Note(duration = Duration.SIXTEENTH_NOTE),
                Note(duration = Duration.EIGHTH_NOTE),
                Rest(duration = Duration.SIXTEENTH_NOTE),
                Note(duration = Duration.THIRTYSECOND_NOTE),
                Note(duration = Duration.THIRTYSECOND_NOTE)
            )
        }
        assertTrue(bar.isBarComplete(TimeSignature(9, 8)))
    }

}