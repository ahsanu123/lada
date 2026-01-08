package ah.lada.dao

import ah.lada.entities.Transaction
import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
abstract class TransactionDao: CudDao<Transaction>() {

    @Query("SELECT * FROM [Transaction]")
    abstract fun getAll(): Flow<List<Transaction>>

    @Query("SELECT * FROM [Transaction] where [type]=:type")
    abstract fun getByType(type: Int): Flow<List<Transaction>>
}