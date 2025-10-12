package dev.toothlonely.workmategalaxyapp.domain

import dev.toothlonely.workmategalaxyapp.data.PlanetsDBEntity
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Planet(
    val title: String,
    @SerialName("url")
    val imageUrl: String,
    val explanation: String,
    @SerialName("media_type")
    val mediaType: String,
)

fun Planet.toPlanetDBEntity() = PlanetsDBEntity(
    title = title,
    imageUrl = imageUrl,
    explanation = explanation,
    mediaType = mediaType,
)