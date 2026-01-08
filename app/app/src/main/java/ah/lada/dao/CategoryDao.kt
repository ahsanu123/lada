package ah.lada.dao

import ah.lada.entities.Category
import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
abstract class CategoryDao : CudDao<Category>(){
    @Query("SELECT * FROM Category")
    abstract fun getAll(): Flow<List<Category>>

    @Query("SELECT * FROM Category Where name=:name")
    abstract fun getByName(name: String): Flow<Category>
}
