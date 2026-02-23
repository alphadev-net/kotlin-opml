package net.alphadev.opml.import

import kotlinx.serialization.decodeFromString
import net.alphadev.opml.format.OpmlFile
import nl.adaptivity.xmlutil.serialization.XML

private val xml by lazy {
    XML()
}

public fun parseOpmlFile(input: String): Result<OpmlFile> = try {
    Result.success(xml.decodeFromString<OpmlFile>(input))
} catch (throwable: Throwable) {
    Result.failure(throwable)
}
