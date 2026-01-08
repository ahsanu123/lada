package ah.lada.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = Category::class,
            parentColumns = ["categoryId"],
            childColumns = ["categoryId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [
        Index(value = ["categoryId"])
    ]
)
@Serializable
data class Budget(
    @PrimaryKey(autoGenerate = true)
    val budgetId: Long = 0,
    val categoryId: Long = 0,
    val amount: Double,
    val date: Long,
)