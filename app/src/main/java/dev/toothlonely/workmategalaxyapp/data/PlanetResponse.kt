package dev.toothlonely.workmategalaxyapp.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PlanetResponse(
    val title: String,
    @SerialName("url")
    val imageUrl: String,
    val explanation: String,
    @SerialName("media_type")
    val mediaType: String,
)