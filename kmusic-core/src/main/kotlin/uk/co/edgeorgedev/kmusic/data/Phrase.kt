package uk.co.edgeorgedev.kmusic.data

import uk.co.edgeorgedev.kmusic.data.Pitch.*

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
 * The representation of a Phrase, a collection of [Bar] objects that share a common [timeSignature]
 * @property timeSignature Time signature applicable to the Phrase; Default to [TimeSignature.FOUR_FOUR]
 * @property bars Mutable list of bars within the Phrase. Defaults to an empty [ArrayList]
 */
data class Phrase(val timeSignature: TimeSignature = TimeSignature.FOUR_FOUR, val bars: MutableList<Bar> = ArrayList()) {

    /**
     * The stave of the Phrase. One of [TrebleStave], [BassStave], [GrandStave] or [UnknownStave]
     */
    val stave: Stave
        get() = generateStave()

    /**
     * Add multiple bars to the current phrase
     * @param bar the bars to add to the phrase
     */
    fun addBars(vararg bar: Bar) = bars.addAll(bar)

    /**
     * Add a single bar to the current phrase
     * @param bar the bar to add to the phrase
     */
    fun addBar(bar: Bar) = bars.add(bar)

    /**
     * The highest pitch within the phrase
     * @return Returns the highest pitch for the phrase; null if no notes exist
     */
    internal fun highestPitch() = getPhraseNotes().maxBy { it.pitch }?.pitch

    /**
     * The lowest pitch within the phrase
     * @return Returns the lowest pitch for the phrase; null if no notes exist
     */
    internal fun lowestPitch() = getPhraseNotes().minBy { it.pitch }?.pitch

    /**
     * Check if all bars have the correct duration of notes for the Phrase's [timeSignature].
     * @return true if all bars are complete; false otherwise
     */
    internal fun isPhraseComplete() = if(bars.isEmpty()) false else bars.none { !it.isBarComplete(timeSignature) }

    /**
     * Get the raw notes (no rests) for the phrase
     */
    private fun getPhraseNotes() = bars.flatMap { it.notes }.filter { it.pitch != REST }

    /**
     * Generates the correct stave based on the highest and lowest note within the phrase
     * @return The correct [Stave] type; [UnknownStave] otherwise
     */
    private fun generateStave(): Stave {
        val highestPitch = highestPitch()
        val lowestPitch = lowestPitch()

        return when {
            lowestPitch == null || highestPitch == null -> UnknownStave
            highestPitch < A6 && lowestPitch > Fs3 ->  TrebleStave
            highestPitch < F4 && lowestPitch > B1 ->  BassStave
            highestPitch > A6 || lowestPitch < B1 ->  GrandStave
            else -> UnknownStave
        }
    }

}