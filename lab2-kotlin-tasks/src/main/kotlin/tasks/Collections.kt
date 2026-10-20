package tasks

/**
 * Блок задач по работе с коллекциями и функциями высшего порядка в Kotlin.
 *
 * @author Мухамеджанов Эльёр Тимурович (ПИН-б-о-24-1 (2))
 * @version 1.0
 * @since 2026-09-03
 */
object Collections {

    /**
     * Задача 3.1. Вычисление среднего возраста людей из списка.
     *
     * Извлекает возраст каждого человека через [map] и вычисляет среднее арифметическое [average].
     * Если переданный список пуст, возвращает 0.0.
     *
     * @param people Список объектов [Person].
     * @return Средний возраст людей в виде [Double] или 0.0 для пустого списка.
     *
     * Пример: `averageAge(listOf(Person("Анна", 25), Person("Иван", 30)))` -> `27.5`
     */
    fun averageAge(people: List<Person>): Double {
        if (people.isEmpty()) return 0.0
        return people.map { it.age }.average()
    }

    /**
     * Задача 3.2. Группировка списка слов по их первой букве.
     *
     * Выполняет группировку слов по первой букве, приведенной к верхнему регистру [uppercaseChar],
     * формируя словарь вида Map<Char, List<String>>.
     *
     * @param words Список исходных слов.
     * @return Отображение [Map], где ключи — заглавные символы, а значения — списки соответствующих слов.
     *
     * Пример: `groupByFirstLetter(listOf("apple", "apricot", "banana"))` ->
     * `{'A' -> ["apple", "apricot"], 'B' -> ["banana"]}`
     */
    fun groupByFirstLetter(words: List<String>): Map<Char, List<String>> {
        return words.filter { it.isNotEmpty() }
            .groupBy { it.first().uppercaseChar() }
    }

    /**
     * Задача 3.3. Поиск самого длинного слова в списке.
     *
     * Находит элемент списка с максимальным значением свойства длины [length].
     * Если список пуст, возвращает null.
     *
     * @param words Список слов.
     * @return Слово наибольшей длины или `null`, если список пуст.
     *
     * Пример: `findLongestWord(listOf("apple", "banana", "pineapple"))` -> `"pineapple"`
     */
    fun findLongestWord(words: List<String>): String? {
        return words.maxByOrNull { it.length }
    }
}
