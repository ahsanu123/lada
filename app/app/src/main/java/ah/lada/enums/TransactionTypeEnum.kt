package ah.lada.enums

enum class TransactionType(val dbVal: Int ){
    Expense(0),
    Income(1);

    companion object  {
        fun fromInt(value: Int): TransactionType {
            val value = entries.firstOrNull { it.dbVal == value }
                ?: TransactionType.Expense
            return value
        }

        fun fromEnum(value: TransactionType) : Int{
            return value.dbVal
        }
    }
}