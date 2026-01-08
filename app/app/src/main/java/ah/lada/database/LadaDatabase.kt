package ah.lada.database

import ah.lada.converters.DateToLongConverter
import ah.lada.converters.TransactionTypeEnumConverter
import ah.lada.dao.AccountDao
import ah.lada.dao.BudgetDao
import ah.lada.dao.CategoryDao
import ah.lada.dao.TransactionDao
import ah.lada.entities.*
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(
    entities = [
        Account::class,
        Budget::class,
        Category::class,
        Transaction::class
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(
    DateToLongConverter::class,
    TransactionTypeEnumConverter::class
)
abstract class LadaDatabase : RoomDatabase(){
    abstract fun accountDao() : AccountDao
    abstract fun budgetDao(): BudgetDao
    abstract fun categoryDao() : CategoryDao
    abstract fun transactionDao() : TransactionDao
}
