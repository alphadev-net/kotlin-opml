package net.alphadev.opml

import de.sipgate.dachlatten.io.readResource
import kotlinx.io.readString
import net.alphadev.opml.exporter.formatOpmlFile
import net.alphadev.opml.import.parseOpmlFile
import kotlin.test.Test
import kotlin.test.assertEquals

class OpmlFormatterTest {

    @Test
    fun formatterReturnsAlreadyFormattedOpmlAsIs() {
        readResource("well-formatted-opml-file.opml") {
            val fileContents = it.readString()

            val parsedOpml = parseOpmlFile(fileContents).getOrThrow()
            val parsed = formatOpmlFile(parsedOpml).getOrThrow()

            assertEquals(fileContents, parsed)
        }
    }
}
