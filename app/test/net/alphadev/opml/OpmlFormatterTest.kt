package net.alphadev.opml

import de.sipgate.dachlatten.io.readResource
import kotlinx.io.readString
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
