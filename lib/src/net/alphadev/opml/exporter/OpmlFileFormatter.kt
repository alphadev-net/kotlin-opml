package net.alphadev.opml.exporter

import net.alphadev.opml.format.OpmlFile
import nl.adaptivity.xmlutil.serialization.XML

private const val INDENT_SIZE = 4

@Suppress("TooGenericExceptionCaught", "SwallowedException")
fun formatOpmlFile(opmlFile: OpmlFile): String? = try {
    XML {
        indent = INDENT_SIZE
    }.encodeToString(OpmlFile.serializer(), opmlFile) + "\n"
} catch (exception: Throwable) {
    null
}
