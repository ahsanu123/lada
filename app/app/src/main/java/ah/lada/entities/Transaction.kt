package ah.lada.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Entity
@Serializable
data class Transaction(
    @PrimaryKey(autoGenerate = true)
    val transactionId: Long = 0,
    val categoryId: Long,
    val date: Long,
    val type: Int,
    val note: String = "",
    val amount: Double,
)