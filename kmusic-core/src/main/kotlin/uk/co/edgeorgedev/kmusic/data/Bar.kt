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
 * The representation of a Bar that can contain an array of [notes]
 * @property tempo The tempo for the bar; Defaults to [Tempo.DEFAULT]
 * @property notes The notes contained within the Bar; Defaults to an empty [ArrayList]
 */
@ScoreDslMarker
data class Bar(var tempo: Tempo = Tempo.DEFAULT, val notes: MutableList<MusicNote> = ArrayList()) {

    /**
     * Add a note to the bar
     * @param note Note to append to current bar
     */
    fun addNote(note: MusicNote) = notes.add(note)

    /**
     * Add multiple notes to the bar
     * @param newNotes Notes to append to current bar
     */
    fun addNotes(vararg newNotes: MusicNote) = notes.addAll(newNotes)

    /**
     * Check if the bar has the correct duration of notes within it.
     * @param timeSignature The time signature for the bar
     * @return true if expected number of beats for time signature is equal to the total number of beats in the bar;
     * false otherwise
     */
    fun isBarComplete(timeSignature: TimeSignature) = timeSignature.totalBeatsPerBar() == totalBeatsInBar()

    /**
     * The total number of beats in the bar
     * @return the total number of beats present in the bar
     */
    fun totalBeatsInBar() = notes.sumByDouble { it.duration.value }

    /**
     * Add DSL functionality to add notes to bar
     */
    operator fun MusicNote.unaryPlus() = this@Bar.notes.add(this)

}