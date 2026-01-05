package ah.lada.models

import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey
import org.mongodb.kbson.ObjectId

class Budgets : RealmObject {
    @PrimaryKey
    var id: ObjectId = ObjectId()
}