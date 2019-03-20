@file:JvmName("IntUtils")
package uk.co.edgeorgedev.kmusic.util

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
 * Check if an integer is a power of two. Returns true if it is a power of two; false otherwise
 */
fun Int.isPow2() = this > 0 && (this and this - 1) == 0