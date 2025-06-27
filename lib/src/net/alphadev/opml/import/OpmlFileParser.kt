package net.alphadev.opml.import

import kotlinx.serialization.decodeFromString
import net.alphadev.opml.format.OpmlFile
import nl.adaptivity.xmlutil.serialization.XML

private val xml by lazy {
    XML()
}

fun parseOpmlFile(input: String): OpmlFile? = try {
    xml.decodeFromString<OpmlFile>(input)
} catch (_: Throwable) {
    null
}
