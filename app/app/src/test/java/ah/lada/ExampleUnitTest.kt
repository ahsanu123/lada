package ah.lada

import org.junit.Test
import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
data class User(val name: String, val age: Int)

class ExampleUnitTest {
  @Test
  fun addition_isCorrect() {
    val u = User("Bob", 25)
    println("$u before hello world")
    assertEquals(4, 2 + 2)
    println("success")
  }
}

