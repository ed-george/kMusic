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

class ScoreTest {

    @Test
    fun `score equality`() {
        val score1 = Score(title = "DSLs Rule", phrases = arrayListOf(
            Phrase(timeSignature = TimeSignature.SIX_EIGHT, bars = arrayListOf(
                Bar(tempo = Tempo(120), notes = arrayListOf(
                    Rest(duration = Duration.HALF_NOTE),
                    Chord(duration = Duration.QUARTER_NOTE, notes = arrayListOf(
                        Note(pitch = Pitch.C4),
                        Note(pitch = Pitch.E4),
                        Note(pitch = Pitch.G4)
                    )),
                    Note(duration = Duration.EIGHTH_NOTE, pitch = Pitch.A3)
                ))
            ))
        ))

        val score2 = Score(title = "DSLs Rule", phrases = arrayListOf(
            Phrase(timeSignature = TimeSignature.SIX_EIGHT, bars = arrayListOf(
                Bar(tempo = Tempo(120), notes = arrayListOf(
                    Rest(duration = Duration.HALF_NOTE),
                    Chord(duration = Duration.QUARTER_NOTE, notes = arrayListOf(
                        Note(pitch = Pitch.C4),
                        Note(pitch = Pitch.E4),
                        Note(pitch = Pitch.G4)
                    )),
                    Note(duration = Duration.EIGHTH_NOTE, pitch = Pitch.A3)
                ))
            ))
        ))

        assertEquals(score1, score2)
    }

}