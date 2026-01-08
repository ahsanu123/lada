package ah.lada.dao

import ah.lada.entities.Account
import ah.lada.entities.Category
import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
abstract class AccountDao : CudDao<Account>(){
    @Query("SELECT * FROM Account")
    abstract fun getAll(): Flow<List<Account>>

    @Query("SELECT * FROM Account Where name=:name")
    abstract fun getByName(name: String): Flow<Account>
}