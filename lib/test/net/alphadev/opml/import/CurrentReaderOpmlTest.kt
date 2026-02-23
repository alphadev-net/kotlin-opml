package net.alphadev.opml.import

import de.sipgate.dachlatten.io.readResource
import kotlinx.io.readString
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.time.ExperimentalTime

@OptIn(ExperimentalTime::class)
class CurrentReaderOpmlTest {
    @Test
    fun testValidOpmlIsReadCorrectly() {
        readResource("current-reader.opml") {
            val parsed = parseOpmlFile(it.readString()).getOrThrow()

            assertEquals("2.0", parsed!!.version)
            assertEquals("Current RSS Subscriptions", parsed.head.title)
            assertEquals(1, parsed.body.outlines.size)

            assertEquals("Jan", parsed.body.outlines[0].text)

            assertEquals(1, parsed.body.outlines[0].children.size)
            assertEquals("Jan‘s Stuff", parsed.body.outlines[0].children[0].title)
        }
    }
}
