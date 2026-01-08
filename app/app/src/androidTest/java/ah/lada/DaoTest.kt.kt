package ah.lada.daotest

import ah.lada.dao.AccountDao
import ah.lada.dao.BudgetDao
import ah.lada.database.LadaDatabase
import ah.lada.entities.Category
import ah.lada.dao.CategoryDao
import ah.lada.dao.TransactionDao
import ah.lada.entities.Account
import android.content.Context
import android.util.Log
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.Json
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class DaosTest {

  private lateinit var accountDao: AccountDao
  private lateinit var budgetDao: BudgetDao
  private lateinit var categoryDao: CategoryDao
  private lateinit var transactionDao: TransactionDao
  private lateinit var ladaDb: LadaDatabase

  // FIXME: this still fail
  // inline fun <reified T> getJson(obj: T): String {
  //   return Json.encodeToString(obj)
  // }

  @Before
  fun createDatabase() {
    val context = ApplicationProvider.getApplicationContext<Context>()

    ladaDb = Room.inMemoryDatabaseBuilder(context, LadaDatabase::class.java).build()

    accountDao = ladaDb.accountDao()
    budgetDao = ladaDb.budgetDao()
    categoryDao = ladaDb.categoryDao()
    transactionDao = ladaDb.transactionDao()
  }

  @Test
  @Throws(Exception::class)
  fun writeAndReadAccountDao() = runBlocking {
    var account = Account(name = "My Bank")

    val insertResult = accountDao.insert(account)
    assertTrue(insertResult.isNotEmpty())

    val all = accountDao.getAll()
    assertNotNull("inserted account is null", all.firstOrNull())
  }

  @Test
  @Throws(Exception::class)
  fun writeCategoryAndReadInList() = runBlocking {
    var category = Category(name = "Stock", description = "Tracking Stock", isTracking = true)
    var expected = Category(categoryId = 1, name = "Stock", description = "Tracking Stock", isTracking = true)

    categoryDao.insert(category)

    val result = categoryDao.getByName("Stock").first()
    assertEquals(expected, result)
  }
}
