package dev.toothlonely.workmategalaxyapp.data

import android.app.Application
import androidx.room.Room
import dev.toothlonely.workmategalaxyapp.domain.Planet
import dev.toothlonely.workmategalaxyapp.domain.toPlanetDBEntity
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.resources.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PlanetsRepository(val application: Application) {

    private val client = HttpClient(OkHttp) {
        install(ContentNegotiation) {
            json()
        }
        install(io.ktor.client.plugins.resources.Resources)
        defaultRequest {
            url("https://api.nasa.gov")
        }
    }

    private val db = Room.databaseBuilder(
        application,
        PlanetDatabase::class.java,
        "database.db"
    ).build()

    private val dao = db.getPlanetsDao()

    suspend fun savePlanets(planets: List<Planet>) = withContext(Dispatchers.IO) {

        val entityPlanets = planets.map { it.toPlanetDBEntity() }

        dao.addPlanets(entityPlanets)
    }

    suspend fun getPlanetsFromCache() = withContext(Dispatchers.IO) {
        dao.getPlanetsFromDatabase()
    }

    suspend fun getPlanets(count: Int): List<Planet> {
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