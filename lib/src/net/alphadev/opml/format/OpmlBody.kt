package net.alphadev.opml.format

import kotlinx.serialization.Serializable
import nl.adaptivity.xmlutil.serialization.XmlSerialName

@Serializable
@XmlSerialName("body", namespace = "", prefix = "")
data class OpmlBody(
    val outlines: List<OpmlOutline>
)
