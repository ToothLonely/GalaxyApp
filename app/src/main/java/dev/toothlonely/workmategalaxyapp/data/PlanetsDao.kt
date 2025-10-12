package dev.toothlonely.workmategalaxyapp.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PlanetsDao {
    @Query(
        """
            SELECT * FROM planets
        """
    )
    suspend fun getPlanetsFromDatabase(): List<PlanetsDBEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addPlanets(planets: List<PlanetsDBEntity>)
}