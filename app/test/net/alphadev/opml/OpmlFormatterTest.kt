package net.alphadev.opml

import kotlinx.io.readString
import net.alphadev.periodicos.testing.readResource
import kotlin.test.Test
import kotlin.test.assertEquals

class OpmlFormatterTest {

    @Test
    fun formatterReturnsAlreadyFormattedOpmlAsIs() {
        readResource("well-formatted-opml-file.opml") {
            val fileContents = it.readString()

            val parsed = formatFile(fileContents)

            assertEquals(fileContents, parsed)
        }
    }
}
