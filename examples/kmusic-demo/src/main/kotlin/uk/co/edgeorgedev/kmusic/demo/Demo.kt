package uk.co.edgeorgedev.kmusic.demo

import uk.co.edgeorgedev.kmusic.data.Duration.HALF_NOTE
import uk.co.edgeorgedev.kmusic.data.Duration.QUARTER_NOTE
import uk.co.edgeorgedev.kmusic.data.Pitch.*
import uk.co.edgeorgedev.kmusic.data.TimeSignature
import uk.co.edgeorgedev.kmusic.dsl.*

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

fun main() {

    val myFirstScore = score {
        title = "My Score"

        +phrase {
            timeSignature = TimeSignature(5, 4)

            +bar {
                +note {
                    duration = HALF_NOTE
                    pitch = C4
                }
                +note {
                    duration = QUARTER_NOTE
                }
                +note {
                    duration = HALF_NOTE
                    pitch = C4
                }
            }
            +bar {
                +note {
                    duration = QUARTER_NOTE
                    pitch = C4
                }
                +note {
                    duration = QUARTER_NOTE
                    pitch = A4
                }
                +rest {
                    duration = QUARTER_NOTE
                }
                +chord {
                    duration = HALF_NOTE
                    +note{ pitch = C3}
                    +note{ pitch = E3}
                    +note{ pitch = G3}
                }
            }
        }
    }

    println(myFirstScore)

}

