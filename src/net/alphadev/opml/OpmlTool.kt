package net.alphadev.opml

import kotlinx.io.buffered
import kotlinx.io.files.Path
import kotlinx.io.files.SystemFileSystem
import kotlinx.io.readString
import kotlinx.io.writeString
import net.alphadev.opml.exporter.formatOpmlFile
import net.alphadev.opml.format.OpmlFile
import net.alphadev.opml.format.OpmlOutline
import net.alphadev.opml.import.parseOpmlFile

internal fun formatFile(input: String): String? {
    val parsedOpml = parseOpmlFile(input) ?: return null
    print(parsedOpml.printDebugInformation)
    return formatOpmlFile(parsedOpml)
}

private val OpmlFile.printDebugInformation: String
    get() {
        var numGroups = 0
        var numItems = 0

        fun List<OpmlOutline>.process() {
            for (item in this) {
                if (item.children.isNotEmpty()) {
                    numGroups++
                    item.children.process()
                } else {
                    numItems++
                }
            }
        }

        body.outlines.process()

        return "Processed $numGroups Groups containing $numItems Items"
    }

internal fun readFile(file: Path) = SystemFileSystem.source(file).buffered().readString()

internal fun writeFile(destFile: Path, opmlContents: String) =
    SystemFileSystem.sink(destFile)
        .buffered()
        .use { it.writeString(opmlContents, 0, opmlContents.length) }

