package net.alphadev.opml.import

import kotlinx.serialization.decodeFromString
import net.alphadev.opml.format.OpmlFile
import nl.adaptivity.xmlutil.serialization.XML

@Suppress("TooGenericExceptionCaught", "SwallowedException")
fun parseOpmlFile(input: String): OpmlFile? = try {
    val xmlSerializer = XML()
    xmlSerializer.decodeFromString<OpmlFile>(input)
} catch (exception: Throwable) {
    null
}
