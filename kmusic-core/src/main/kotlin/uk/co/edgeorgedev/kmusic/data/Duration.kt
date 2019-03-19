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
enum class Duration(private val value: Double) {
    SEMIBREVE(4.0), WHOLE_NOTE(4.0),
    MINIM(2.0), HALF_NOTE(2.0),
    CROTCHET(1.0), QUARTER_NOTE(1.0),
    QUAVER(0.5), EIGHT_NOTE(0.5),
    SEMI_QUAVER(0.25), SIXTEENTH_NOTE(0.25),
    DEMI_SEMI_QUAVER(0.125), THIRTYSECOND_NOTE(0.125);
}