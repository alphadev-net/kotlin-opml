package net.alphadev.opml.format


import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName
import nl.adaptivity.xmlutil.serialization.XmlSerialName

@Serializable
@XmlSerialName(value = "opml", namespace = "", prefix = "")
data class OpmlFile(
    @SerialName("version") val version: String,
    val head: OpmlHead,
    val body: OpmlBody
)
