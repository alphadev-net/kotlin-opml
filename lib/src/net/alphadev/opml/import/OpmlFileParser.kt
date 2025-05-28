package net.alphadev.opml.import

import kotlinx.serialization.decodeFromString
import net.alphadev.opml.format.OpmlFile
import nl.adaptivity.xmlutil.serialization.XML

fun parseOpmlFile(input: String): OpmlFile? = try {
    XML().decodeFromString<OpmlFile>(input)
} catch (_: Throwable) {
    null
}
