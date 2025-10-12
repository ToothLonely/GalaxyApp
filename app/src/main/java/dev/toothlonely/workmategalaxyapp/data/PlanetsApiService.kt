package dev.toothlonely.workmategalaxyapp.data

import io.ktor.client.HttpClient
import okhttp3.OkHttp

interface PlanetsApiService {

    suspend fun get(client: HttpClient) {
        client
    }

}