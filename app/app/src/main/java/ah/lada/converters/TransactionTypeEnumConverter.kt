package ah.lada.converters

import ah.lada.enums.TransactionType
import androidx.room.TypeConverter


class TransactionTypeEnumConverter {
    @TypeConverter
    fun fromDb(value: Int): TransactionType {
        return TransactionType.fromInt(value)
    }

    @TypeConverter
    fun toDb(value: TransactionType): Int{
        return TransactionType.fromEnum(value)
    }
}