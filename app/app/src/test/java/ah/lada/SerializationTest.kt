package ah.lada

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import org.junit.Test

@Serializable
data class Data(val a: Int, val b: String)

class KotlinXSerializationTest {
    @Test
    fun checkKotlinXJsonSerializer(){
        val json = Json.encodeToString(Data(42, "str"))
        println("encoded data as json $json")
    }
}