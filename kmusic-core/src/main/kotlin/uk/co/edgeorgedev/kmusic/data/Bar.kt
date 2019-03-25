package uk.co.edgeorgedev.kmusic.data

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
class Bar(var tempo: Tempo = Tempo.DEFAULT, val notes: MutableList<Note> = ArrayList()) {

    /**
     * Add a note to the bar
     * @param note Note to append to current bar
     */
    fun addNote(note: Note) = notes.add(note)

    /**
     * Add multiple notes to the bar
     * @param newNotes Notes to append to current bar
     */
    fun addNotes(vararg newNotes: Note) = notes.addAll(newNotes)

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
     * @see Any.equals
     */
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Bar

        if (tempo != other.tempo) return false
        if (notes != other.notes) return false

        return true
    }

    /**
     * @see Any.hashCode
     */
    override fun hashCode(): Int {
        var result = tempo.hashCode()
        result = 31 * result + notes.hashCode()
        return result
    }

}