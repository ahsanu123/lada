package ah.lada.dao

import ah.lada.entities.Budget
import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
abstract class BudgetDao :CudDao<Budget>() {

    @Query("SELECT * FROM Budget")
    abstract fun getAll(): Flow<List<Budget>>
}