package uk.co.edgeorgedev.kmusic.dsl

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

/**
 * Add DSL Scoping
 */
@DslMarker annotation class ScoreDslMarker

/**
 * Create [Score] object from block
 * @param block Initialisation block
 * @see Score
 */
fun score(block: Score.() -> Unit): Score = Score().apply(block)
/**
 * Create [Phrase] object from block
 * @param block Initialisation block
 * @see Phrase
 */
fun phrase(block: Phrase.() -> Unit): Phrase = Phrase().apply(block)
/**
 * Create [Bar] object from block
 * @param block Initialisation block
 * @see Bar
 */
fun bar(block: Bar.() -> Unit): Bar = Bar().apply(block)
/**
 * Create [Note] object from block
 * @param block Initialisation block
 * @see Note
 */
fun note(block: Note.() -> Unit): Note = Note().apply(block)
/**
 * Create [Rest] object from block
 * @param block Initialisation block
 * @see Rest
 */
fun rest(block: Rest.() -> Unit): Rest = Rest().apply(block)
/**
 * Create [Chord] object from block
 * @param block Initialisation block
 * @see Chord
 */
fun chord(block: Chord.() -> Unit): Chord = Chord().apply(block)