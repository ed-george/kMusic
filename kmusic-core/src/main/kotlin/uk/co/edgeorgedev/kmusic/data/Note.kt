package uk.co.edgeorgedev.kmusic.data

import java.io.Serializable

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
 * Represents a Note with a given [pitch] and duration [value].
 * @property pitch The note being represented from min [Pitch.C0] to max [Pitch.G9]; Defaults to [Pitch.C4].
 * @property value The duration of the note; Defaults to [Duration.QUARTER_NOTE] / [Duration.CROTCHET]
 */
data class Note(val pitch: Pitch = Pitch.C4, val value: Duration = Duration.QUARTER_NOTE): Cloneable, Serializable