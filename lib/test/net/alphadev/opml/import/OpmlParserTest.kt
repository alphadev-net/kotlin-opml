package net.alphadev.opml.import

import kotlinx.io.readString
import net.alphadev.periodicos.testing.readResource
import kotlin.test.Test
import kotlin.test.assertEquals

class OpmlParserTest {
    @Test
    fun testValidOpmlIsReadCorrectly() {
        readResource("some.opml") {
            val parsed = parseOpmlFile(it.readString())

            assertEquals("2.0", parsed!!.version)
            assertEquals("Feeds", parsed.head.title)
            assertEquals(2, parsed.body.outlines.size)

            assertEquals("A text", parsed.body.outlines[0].text)

            assertEquals(2, parsed.body.outlines[1].children.size)
            assertEquals("B title", parsed.body.outlines[1].children[0].title)
            assertEquals("C title", parsed.body.outlines[1].children[1].title)
        }
    }
}
