package net.alphadev.opml.format

import kotlinx.serialization.Serializable
import nl.adaptivity.xmlutil.serialization.XmlElement
import nl.adaptivity.xmlutil.serialization.XmlSerialName
import kotlin.time.ExperimentalTime
import kotlin.time.Instant

@ExperimentalTime
@Serializable
@XmlSerialName("head", namespace = "", prefix = "")
public data class OpmlHead(
    @XmlElement val title: String,
    @XmlElement val dateCreated: Instant? = null
)
