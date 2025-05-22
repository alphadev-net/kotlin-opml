
import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.core.main
import com.github.ajalt.clikt.parameters.arguments.argument
import com.github.ajalt.clikt.parameters.types.file
import kotlinx.io.files.Path
import net.alphadev.opml.formatFile
import net.alphadev.opml.readFile
import net.alphadev.opml.writeFile
import kotlin.time.measureTime

fun main(args: Array<String>) = OpmlTool().main(args)

internal class OpmlTool: CliktCommand() {
    override val printHelpOnEmptyArgs = true

    private val file by argument(help="OPML file to format")
        .file(
            canBeDir = false,
            mustBeWritable = true,
            mustBeReadable = true,
            mustExist = true
        )
    override fun run() {
        val duration = measureTime {
            val path = Path(file.path)
            val fileContents = readFile(path)
            val formattedOpml = formatFile(fileContents) ?: return
            writeFile(path, formattedOpml)
        }
        println(" in $duration")
    }
}
