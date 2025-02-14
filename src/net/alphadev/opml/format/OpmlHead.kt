package net.alphadev.opml.format

import kotlinx.serialization.Serializable
import nl.adaptivity.xmlutil.serialization.XmlElement
import nl.adaptivity.xmlutil.serialization.XmlSerialName

@Serializable
@XmlSerialName("head", namespace = "", prefix = "")
data class OpmlHead(
    @XmlElement val title: String
)
