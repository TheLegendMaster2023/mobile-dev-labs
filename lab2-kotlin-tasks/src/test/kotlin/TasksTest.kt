import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import tasks.*

class TasksTest {

    @Test
    fun testBasicSyntax() {
        assertEquals("Привет, Анна! Через 10 лет тебе будет 35 лет.", BasicSyntax.greetUser("Анна", 25))
        assertEquals("Зима", BasicSyntax.getSeason(12))
        assertEquals("Зима", BasicSyntax.getSeason(1))
        assertEquals("Весна", BasicSyntax.getSeason(3))
        assertEquals("Лето", BasicSyntax.getSeason(7))
        assertEquals("Осень", BasicSyntax.getSeason(10))
        assertEquals("Некорректный месяц", BasicSyntax.getSeason(13))

        assertEquals(120L, BasicSyntax.factorial(5))
        assertEquals(1L, BasicSyntax.factorial(0))
        assertEquals(-1L, BasicSyntax.factorial(-4))
    }

    @Test
    fun testNullSafety() {
        assertEquals(123, NullSafety.parseIntSafe("123"))
        assertNull(NullSafety.parseIntSafe("abc"))
        assertNull(NullSafety.parseIntSafe(null))

        val input = listOf(1, null, 3, null, 5)
        val expected = listOf(2, 6, 10)
        assertEquals(expected, NullSafety.filterNonNullAndDouble(input))
    }

    @Test
    fun testCollections() {
        val people = listOf(Person("Анна", 25), Person("Иван", 35))
        assertEquals(30.0, Collections.averageAge(people), 0.001)
        assertEquals(0.0, Collections.averageAge(emptyList()), 0.001)

        val words = listOf("apple", "apricot", "banana")
        val grouped = Collections.groupByFirstLetter(words)
        assertEquals(listOf("apple", "apricot"), grouped['A'])
        assertEquals(listOf("banana"), grouped['B'])

        assertEquals("pineapple", Collections.findLongestWord(listOf("apple", "banana", "pineapple")))
        assertNull(Collections.findLongestWord(emptyList()))
    }

    @Test
    fun testCoroutines() = runBlocking {
        val results = Coroutines.runParallelTasks()
        assertEquals(listOf("Результат 1", "Результат 2", "Результат 3"), results)
    }

    @Test
    fun testAdvancedTasks() {
        val numRes = AdvancedTasks.processUserInput("1, 2, 3, 4")
        assertEquals(10, numRes["sum"])
        assertEquals(2.5, numRes["average"])
        assertEquals(4, numRes["count"])
        assertEquals(listOf(1, 2, 3, 4), numRes["sorted"])

        val textRes = AdvancedTasks.processUserInput("Hello world from Kotlin")
        assertEquals(4, textRes["wordCount"])
        assertEquals("Kotlin", textRes["longestWord"])
        assertEquals(20, textRes["charCount"])
    }
}
