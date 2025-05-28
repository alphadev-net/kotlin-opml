package net.alphadev.opml

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.core.main
import com.github.ajalt.clikt.parameters.arguments.argument
import com.github.ajalt.clikt.parameters.types.path
import kotlinx.io.files.Path
import kotlin.time.measureTime

fun main(args: Array<String>) = OpmlTool().main(args)

internal class OpmlTool: CliktCommand() {
    override val printHelpOnEmptyArgs = true

    private val path by argument(help="OPML file to format")
        .path(
            canBeDir = false,
            mustBeWritable = true,
            mustBeReadable = true,
            mustExist = true
        )
    override fun run() {
        val duration = measureTime {
            val path = Path(path.toAbsolutePath().toString())
            val fileContents = readFile(path)
            val formattedOpml = formatFile(fileContents) ?: return
            writeFile(path, formattedOpml)
        }
        println(" in $duration")
    }
}
