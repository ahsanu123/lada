package ah.lada

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
  @Test
  // @DisplayName("addition is fucking correct")
  fun addition_isCorrect() {
    println("before hello world")
    assertEquals(4, 2 + 2)
    println("success")
  }

  @Test
  // @DisplayName("addition is fucking correct")
  fun justhello_isCorrect() {
    println("just hello world")
  }

	// @DisplayName("A negative value for year is not supported by the leap year computation.")
	// @ParameterizedTest(name = "For example, year {0} is not supported.")
	// @ValueSource(ints = { -1, -4 })
	// fun if_it_is_negative(year: int) {
	// }
}

