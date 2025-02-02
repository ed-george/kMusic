package uk.co.edgeorgedev.kmusic.data

import uk.co.edgeorgedev.kmusic.dsl.ScoreDslMarker

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
 * Representation of a musical note i.e. a musical element within a bar
 */
@ScoreDslMarker
sealed class MusicNote {
    /**
     * The duration of the musical element within the bar
     */
    abstract var duration: Duration
}

/**
 * Represents a Note with a given [pitch] and duration [duration].
 * @property pitch The note being represented from min [Pitch.C0] to max [Pitch.G9]; Defaults to [Pitch.C4].
 * @property duration The duration of the note; Defaults to [Duration.QUARTER_NOTE] / [Duration.CROTCHET]
 */
data class Note(var pitch: Pitch = Pitch.C4, override var duration: Duration = Duration.QUARTER_NOTE) : MusicNote()

/**
 * Represents a Rest with a given duration [duration].
 * @property duration The duration of the note; Defaults to [Duration.QUARTER_NOTE] / [Duration.CROTCHET]
 */
data class Rest(override var duration: Duration = Duration.QUARTER_NOTE) : MusicNote()

/**
 * Represents a Chord with given [notes] and a duration [duration].
 * @property notes The notes that make up the chord
 * @property duration The duration of the note; Defaults to [Duration.QUARTER_NOTE] / [Duration.CROTCHET]
 */
data class Chord(var notes: MutableList<Note> = ArrayList(), override var duration: Duration = Duration.QUARTER_NOTE) : MusicNote() {
    /**
     * Add DSL functionality to add notes to chord
     */
    operator fun Note.unaryPlus() = this@Chord.notes.add(this)
}