package uk.co.edgeorgedev.kmusic.dsl

import org.junit.Assert.assertEquals
import org.junit.Test
import uk.co.edgeorgedev.kmusic.data.*

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

class DslTest {

    @Test
    fun `score dsl returns correct object`() {
        val score = score {
            title = "Test Title"
        }
        assertEquals(Score(title = "Test Title"), score)
    }

    @Test
    fun `phrase dsl returns correct object`() {
        val phrase = phrase {
            timeSignature = TimeSignature.THREE_FOUR
        }
        assertEquals(Phrase(timeSignature = TimeSignature.THREE_FOUR), phrase)
    }

    @Test
    fun `bar dsl returns correct object`() {
        val bar = bar {
            tempo = Tempo(165)
        }
        assertEquals(Bar(tempo = Tempo(165)), bar)
    }

    @Test
    fun `note dsl returns correct object`() {
        val note = note {
            pitch = Pitch.A3
            duration = Duration.MINIM
        }
        assertEquals(Note(pitch = Pitch.A3, duration = Duration.MINIM), note)
    }

    @Test
    fun `rest dsl returns correct object`() {
        val rest = rest {
            duration = Duration.MINIM
        }
        assertEquals(Rest(Duration.MINIM), rest)
    }

    @Test
    fun `chord dsl returns correct object`() {
        val chord = chord {
            duration = Duration.MINIM
            +note { pitch = Pitch.C3 }
            +note { pitch = Pitch.E3 }
            +note { pitch = Pitch.G3 }
        }
        assertEquals(Chord(duration = Duration.MINIM, notes = arrayListOf(
            Note(Pitch.C3),
            Note(Pitch.E3),
            Note(Pitch.G3)
        )), chord)
    }

    @Test
    fun `dsl returns correct object`() {

        val nonDslScore = Score(title = "DSLs Rule", phrases = arrayListOf(
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

        val dslScore = score {
            title = "DSLs Rule"
            +phrase {
                timeSignature = TimeSignature.SIX_EIGHT
                +bar {
                    tempo = Tempo(120)
                    +rest {
                        duration = Duration.HALF_NOTE
                    }
                    +chord {
                        duration = Duration.QUARTER_NOTE
                        +note { pitch = Pitch.C4 }
                        +note { pitch = Pitch.E4 }
                        +note { pitch = Pitch.G4 }
                    }
                    +note {
                        duration = Duration.EIGHTH_NOTE
                        pitch = Pitch.A3
                    }
                }
            }
        }

        assertEquals(nonDslScore, dslScore)
    }

}