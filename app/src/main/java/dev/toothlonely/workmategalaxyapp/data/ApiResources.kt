package dev.toothlonely.workmategalaxyapp.data

import io.ktor.resources.Resource
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@Resource("/planetary/apod")
class ApiResources(
    @SerialName("api_key")
    val apiKey: String = "DEMO_KEY",
    val count: Int = 2
)