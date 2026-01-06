package ah.lada.daotest

import ah.lada.database.LadaDatabase
import ah.lada.models.Category
import ah.lada.models.CategoryDao
import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import kotlinx.serialization.json.Json

@RunWith(AndroidJUnit4::class)
class CategoryDaoTest {

    private lateinit var categoryDao: CategoryDao
    private lateinit var ladaDb: LadaDatabase

    @Before
    fun createDatabase(){
        val context = ApplicationProvider.getApplicationContext<Context>()

        ladaDb = Room.inMemoryDatabaseBuilder(context, LadaDatabase::class.java).build()
        categoryDao = ladaDb.categoryDao()
    }
    @Test
    @Throws(Exception::class)
    fun writeUserAndReadInList()  = runBlocking{
        val json = Json { prettyPrint = true }

        var category = Category(name = "Stock", description = "Tracking Stock", isTracking = true)
        var expected = Category(categoryId = 1, name = "Stock", description = "Tracking Stock", isTracking = true)

        categoryDao.insert(category)

        val result = categoryDao.getByName("Stock").first()
        assertEquals(expected, result)

        println(json.encodeToString(Category.serializer(), result))
    }
}
