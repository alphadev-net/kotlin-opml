package net.alphadev.opml

import kotlinx.io.buffered
import kotlinx.io.files.Path
import kotlinx.io.files.SystemFileSystem
import kotlinx.io.readString
import kotlinx.io.writeString
import net.alphadev.opml.format.OpmlFile
import net.alphadev.opml.format.OpmlOutline
import net.alphadev.opml.exporter.formatOpmlFile
import net.alphadev.opml.import.parseOpmlFile
import kotlin.time.measureTime

fun main(args: Array<String>) {
    assert(args.size == 1)

    val duration = measureTime {
        val file = Path(args.first())
        val fileContents = readFile(file)
        val formattedOpml = formatFile(fileContents) ?: return
        writeFile(file, formattedOpml)
    }
    println(" in $duration")
}

internal fun formatFile(input: String): String? {
    val parsedOpml = parseOpmlFile(input) ?: return null
    print(parsedOpml.printDebugInformation)
    return formatOpmlFile(parsedOpml)
}

val OpmlFile.printDebugInformation: String
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

private fun readFile(file: Path) = SystemFileSystem.source(file).buffered().readString()

private fun writeFile(destFile: Path, opmlContents: String) =
    SystemFileSystem.sink(destFile)
        .buffered()
        .use { it.writeString(opmlContents, 0, opmlContents.length) }

