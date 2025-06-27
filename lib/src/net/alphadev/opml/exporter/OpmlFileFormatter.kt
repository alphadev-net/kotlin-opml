package net.alphadev.opml.exporter

import net.alphadev.opml.format.OpmlFile
import nl.adaptivity.xmlutil.serialization.XML

private const val INDENT_SIZE = 4

private val xml by lazy {
    XML {
        indent = INDENT_SIZE
    }
}

fun formatOpmlFile(opmlFile: OpmlFile): String? = try {
    xml.encodeToString(OpmlFile.serializer(), opmlFile) + "\n"
} catch (_: Throwable) {
    null
}
