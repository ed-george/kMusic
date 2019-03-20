package uk.co.edgeorgedev.kmusic.util

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

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

class IntExtTest {

    @Test
    fun `valid power of two`() {
        assertTrue(1024.isPow2())
    }

    @Test
    fun `invalid power of two`() {
        assertFalse(42.isPow2())
    }

    @Test
    fun `invalid negative power of two`() {
        assertFalse((-8).isPow2())
    }

    @Test
    fun `invalid zero power of two`() {
        assertFalse(0.isPow2())
    }


}