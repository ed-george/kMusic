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
 * Representation of a score, comprised of multiple [phrases]
 * @property title The nullable title of the score; Defaults to null
 * @property phrases The phrases contained within the score; Defaults to an empty [ArrayList]
 */
data class Score(val title: String? = null, val phrases: MutableList<Phrase> = ArrayList()) {

    /**
     * Add multiple phrases to the score
     * @param phrase The phrases to add
     */
    fun addPhrases(vararg phrase: Phrase) {
        phrases.addAll(phrase)
    }

    /**
     * Add a single phrase to the score
     * @param phrase The phrase to add
     */
    fun addPhrase(phrase: Phrase) {
        phrases.add(phrase)
    }

}