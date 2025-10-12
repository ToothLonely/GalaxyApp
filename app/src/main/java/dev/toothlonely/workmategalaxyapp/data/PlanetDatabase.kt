package dev.toothlonely.workmategalaxyapp.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    version = 1,
    entities = [
        PlanetsDBEntity::class,
    ]
)
abstract class PlanetDatabase: RoomDatabase() {
    abstract fun getPlanetsDao(): PlanetsDao
}