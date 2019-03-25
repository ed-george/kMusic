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
 * Representation of a note's duration from [THIRTYSECOND_NOTE] to [WHOLE_NOTE]
 * Traditional names and their equivalent modern names are available (e.g. [CROTCHET] and [QUARTER_NOTE])
 * @property value The note's relative duration
 */
enum class Duration(val value: Double) {
    /**
     * Classical representation of 4 beat note (Alias of [WHOLE_NOTE])
     */
    SEMIBREVE(4.0),
    /**
     * Modern representation of 4 beat note (Alias of [SEMIBREVE])
     */
    WHOLE_NOTE(4.0),
    /**
     * Classical representation of w beat note (Alias of [HALF_NOTE])
     */
    MINIM(2.0),
    /**
     * Modern representation of 2 beat note (Alias of [MINIM])
     */
    HALF_NOTE(2.0),
    /**
     * Classical representation of 1 beat note (Alias of [QUARTER_NOTE])
     */
    CROTCHET(1.0),
    /**
     * Modern representation of 1 beat note (Alias of [CROTCHET])
     */
    QUARTER_NOTE(1.0),
    /**
     * Classical representation of 0.5 beat note (Alias of [EIGHTH_NOTE])
     */
    QUAVER(0.5),
    /**
     * Modern representation of 0.5 beat note (Alias of [QUAVER])
     */
    EIGHTH_NOTE(0.5),
    /**
     * Classical representation of 0.25 beat note (Alias of [SIXTEENTH_NOTE])
     */
    SEMI_QUAVER(0.25),
    /**
     * Modern representation of 0.25 beat note (Alias of [SEMI_QUAVER])
     */
    SIXTEENTH_NOTE(0.25),
    /**
     * Classical representation of 0.125 beat note (Alias of [THIRTYSECOND_NOTE])
     */
    DEMI_SEMI_QUAVER(0.125),
    /**
     * Modern representation of 0.125 beat note (Alias of [DEMI_SEMI_QUAVER])
     */
    THIRTYSECOND_NOTE(0.125);
}