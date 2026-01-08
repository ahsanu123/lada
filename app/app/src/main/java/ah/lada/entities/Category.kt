package ah.lada.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Entity
@Serializable
data class Category(
    @PrimaryKey(autoGenerate = true)
    val categoryId : Long = 0,
    val name: String,
    val description: String?,
    val isTracking: Boolean
)