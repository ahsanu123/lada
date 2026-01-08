package ah.lada.models

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import kotlinx.serialization.Serializable

@Serializable
@Entity
data class Category(
    @PrimaryKey(autoGenerate = true)
    val categoryId : Int = 0,
    val name: String,
    val description: String?,
    val isTracking: Boolean
)

@Dao
interface CategoryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg categories: Category)

    @Query("SELECT * FROM Category")
    fun getAll(): Flow<List<Category>>

    @Query("SELECT * FROM Category Where name=:name")
    fun getByName(name: String): Flow<Category>

    @Update
    fun update(vararg categories: Category)

    @Delete
    fun delete(vararg categories: Category)
}
