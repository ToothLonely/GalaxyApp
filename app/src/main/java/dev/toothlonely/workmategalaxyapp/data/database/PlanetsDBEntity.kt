package dev.toothlonely.workmategalaxyapp.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.SerialName

@Entity(tableName = "planets")
data class PlanetsDBEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val title: String,
    @SerialName("url")
    val imageUrl: String,
    val explanation: String,
    @SerialName("media_type")
    val mediaType: String?,
)