package dev.toothlonely.workmategalaxyapp.data

import android.app.Application
import androidx.room.Room
import dev.toothlonely.workmategalaxyapp.data.database.PlanetDatabase
import dev.toothlonely.workmategalaxyapp.domain.Planet
import dev.toothlonely.workmategalaxyapp.domain.toPlanetDBEntity
import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class PlanetsRepository(application: Application) {

    private val client = HttpClient(OkHttp) {
        install(ContentNegotiation) {
            json(
                Json {
                    ignoreUnknownKeys = true
                }
            )
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

    @OptIn(ExperimentalSerializationApi::class)
    suspend fun getPlanets(page: Int): List<Planet> {
/*        val range = getRangeOfDates(page)
        val startDate = range[0]
        val endDate = range[1]

        return client.get("https://api.nasa.gov/planetary/apod") {
            url {
                with(parameters) {
                    append("api_key", "VyLlVvtsB7gcrTTWfpQqLftUkE0ofUsCeH8YXqEV")
                    append("start_date", startDate)
                    append("end_date", endDate)
                    append("thumbs", "true")
                }
            }
        }.body()*/
        val json = Json {
            ignoreUnknownKeys = true
            allowTrailingComma = true
        }

        val pageSize = 10
        val start = pageSize * (page - 1)
        val end = start + pageSize

        val response = STUB.response
        val list = json.decodeFromString<List<Planet>>(response)
        return list.subList(start, end)
    }

    private fun getRangeOfDates(page: Int): List<String> {
        val dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        val yesterday = LocalDate.now().minusDays(1)
        val pageSize = 10

        val endDate = yesterday.minusDays((pageSize * (page - 1)).toLong())
        val startDate = endDate.minusDays((pageSize - 1).toLong())

        return listOf(startDate.format(dateFormatter), endDate.format(dateFormatter))
    }

    fun close() {
        client.close()
    }
}