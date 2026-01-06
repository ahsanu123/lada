package ah.lada.database

import ah.lada.models.Category
import ah.lada.models.CategoryDao
import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [
        Category::class
    ],
    version = 1,
    exportSchema = false
)
abstract class LadaDatabase : RoomDatabase(){
    abstract fun categoryDao() : CategoryDao
}
