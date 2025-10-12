package dev.toothlonely.workmategalaxyapp.data

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.resources.get
import io.ktor.serialization.kotlinx.json.json

class PlanetsRepository {

    private val client = HttpClient(OkHttp) {
        install(ContentNegotiation) {
            json()
        }
        install(io.ktor.client.plugins.resources.Resources)
        defaultRequest {
            url("https://api.nasa.gov")
        }
    }

    suspend fun getPlanets(count: Int): List<PlanetResponse> {
        return client.get(
            resource = ApiResources(
                count = count
            )
        ).body()
    }

    fun close() {
        client.close()
    }

}