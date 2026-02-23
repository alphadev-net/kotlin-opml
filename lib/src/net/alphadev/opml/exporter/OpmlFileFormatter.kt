package net.alphadev.opml.exporter

import net.alphadev.opml.format.OpmlFile
import nl.adaptivity.xmlutil.serialization.XML
import kotlin.time.ExperimentalTime

private const val INDENT_SIZE = 4

private val xml by lazy {
    XML {
        indent = INDENT_SIZE
    }
}

@ExperimentalTime
public fun formatOpmlFile(opmlFile: OpmlFile): Result<String> = try {
    Result.success(xml.encodeToString(OpmlFile.serializer(), opmlFile) + "\n")
} catch (throwable: Throwable) {
    Result.failure(throwable)
}
