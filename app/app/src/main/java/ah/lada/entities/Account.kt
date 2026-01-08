package ah.lada.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Entity
@Serializable
data class Account (
    @PrimaryKey(autoGenerate = true)
    val accountId: Long = 0,
    val name: String,
    val description: String = "",
    val balance: Double = 0.0,
    val default: Boolean = false
)