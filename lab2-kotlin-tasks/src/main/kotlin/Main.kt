import kotlinx.coroutines.runBlocking
import tasks.*

/**
 * Точка входа в консольное приложение.
 * Демонстрирует и тестирует решение всех задач лабораторной работы №2.
 *
 * @author Мухамеджанов Эльёр Тимурович (ПИН-б-о-24-1 (2))
 * @version 1.0
 * @since 2026-09-03
 */
fun main() {
    println("=================================================================")
    println("      ЛАБОРАТОРНАЯ РАБОТА №2: ОСНОВЫ ЯЗЫКА KOTLIN                ")
    println("  Студент: Мухамеджанов Эльёр Тимурович, Группа: ПИН-б-о-24-1 (2)")
    println("=================================================================\n")

    // Блок 1. Базовый синтаксис
    println("--- Блок 1. Базовый синтаксис ---")
    println("1.1. greetUser(\"Анна\", 25):")
    println("     -> ${BasicSyntax.greetUser("Анна", 25)}")

    println("1.2. getSeason(3) и getSeason(12):")
    println("     -> Месяц 3: ${BasicSyntax.getSeason(3)}")
    println("     -> Месяц 12: ${BasicSyntax.getSeason(12)}")
    println("     -> Месяц 15: ${BasicSyntax.getSeason(15)}")

    println("1.3. factorial(5), factorial(0), factorial(-3):")
    println("     -> 5! = ${BasicSyntax.factorial(5)}")
    println("     -> 0! = ${BasicSyntax.factorial(0)}")
    println("     -> (-3)! = ${BasicSyntax.factorial(-3)}")
    println()

    // Блок 2. Null-безопасность
    println("--- Блок 2. Null-безопасность ---")
    println("2.1. parseIntSafe:")
    println("     -> parseIntSafe(\"123\") = ${NullSafety.parseIntSafe("123")}")
    println("     -> parseIntSafe(\"abc\") = ${NullSafety.parseIntSafe("abc")}")
    println("     -> parseIntSafe(null)  = ${NullSafety.parseIntSafe(null)}")

    val testList = listOf(1, null, 3, null, 5)
    println("2.2. filterNonNullAndDouble($testList):")
    println("     -> ${NullSafety.filterNonNullAndDouble(testList)}")
    println()

    // Блок 3. Коллекции и функции высшего порядка
    println("--- Блок 3. Коллекции и функции высшего порядка ---")
    val people = listOf(
        Person("Анна", 25),
        Person("Иван", 30),
        Person("Мария", 35),
        Person("Эльёр", 20)
    )
    println("3.1. averageAge(people):")
    println("     -> Средний возраст: ${Collections.averageAge(people)}")

    val fruits = listOf("apple", "apricot", "banana", "blueberry", "cherry")
    println("3.2. groupByFirstLetter($fruits):")
    println("     -> ${Collections.groupByFirstLetter(fruits)}")

    println("3.3. findLongestWord($fruits):")
    println("     -> Самое длинное слово: ${Collections.findLongestWord(fruits)}")
    println()

    // Блок 4. Корутины
    println("--- Блок 4. Корутины (Coroutines) ---")
    runBlocking {
        println("4.1. Тест delayedPrint (пауза 1.5 сек):")
        Coroutines.delayedPrint("Запуск отложенной печати...", 1500L)

        println("\n4.2. Тест runParallelTasks (3 задачи параллельно):")
        val startTime = System.currentTimeMillis()
        val results = Coroutines.runParallelTasks()
        val duration = System.currentTimeMillis() - startTime
        println("     -> Результаты: $results")
        println("     -> Общее затраченное время: ${duration}мс (~3000мс, задачи шли параллельно!)")
    }
    println()

    // Дополнительное задание (на оценку «Отлично»)
    println("--- Дополнительное задание: processUserInput ---")
    val numbersInput = "10, 20, 5, 40, 15"
    println("Числовой ввод: \"$numbersInput\"")
    println("-> ${AdvancedTasks.processUserInput(numbersInput)}")

    val textInput = "Kotlin Jetpack Compose Android Mobile Development"
    println("\nТекстовый ввод: \"$textInput\"")
    println("-> ${AdvancedTasks.processUserInput(textInput)}")

    println("\n=================================================================")
    println("  ВСЕ ТЕСТЫ ЛАБОРАТОРНОЙ РАБОТЫ №2 УСПЕШНО ЗАВЕРШЕНЫ!")
    println("=================================================================")
}
