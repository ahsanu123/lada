package ah.lada.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update

abstract class CudDao<T>{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(vararg categories: T) : List<Long>

    @Update
    abstract fun update(vararg categories: T) : Int

    @Delete
    abstract fun delete(vararg categories: T) : Int
}