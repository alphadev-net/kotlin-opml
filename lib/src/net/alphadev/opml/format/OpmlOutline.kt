package net.alphadev.opml.format

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import nl.adaptivity.xmlutil.serialization.XmlSerialName

@Serializable
@XmlSerialName("outline", namespace = "", prefix = "")
data class OpmlOutline(
    @SerialName("text") val text: String,
    @SerialName("title") val title: String,
    @SerialName("type") val type: String? = null,
    @SerialName("htmlUrl") val htmlUrl: String? = null,
    @SerialName("xmlUrl") val xmlUrl: String? = null,
    @XmlSerialName("outline", namespace = "", prefix = "") val children: List<OpmlOutline> = emptyList()
)
