package tasks

/**
 * Дополнительные задачи повышенной сложности (на оценку «Отлично»).
 *
 * @author Мухамеджанов Эльёр Тимурович (ПИН-б-о-24-1 (2))
 * @version 1.0
 * @since 2026-09-03
 */
object AdvancedTasks {

    /**
     * Анализирует пользовательский ввод:
     * 1. При передаче `null` возвращает пустую Map.
     * 2. Если строка представляет собой набор целых чисел через запятую (например, `"1,2,3,4,5"`):
     *    - `"sum"` -> сумма чисел (Int);
     *    - `"average"` -> среднее арифметическое (Double);
     *    - `"count"` -> количество элементов (Int);
     *    - `"sorted"` -> отсортированный по возрастанию список (List<Int>).
     * 3. Если строка содержит произвольный текст со словами:
     *    - `"wordCount"` -> количество слов (Int);
     *    - `"longestWord"` -> самое длинное слово (String);
     *    - `"charCount"` -> суммарное количество символов без пробелов (Int).
     *
     * @param input Исходная строка, введенная пользователем (может быть null).
     * @return Отображение [Map] с расчетными характеристиками введенных данных.
     */
    fun processUserInput(input: String?): Map<String, Any> {
        if (input == null) return emptyMap()

        val trimmed = input.trim()
        if (trimmed.isEmpty()) return emptyMap()

        // Проверяем, состоит ли строка из чисел, разделённых запятыми
        val parts = trimmed.split(",").map { it.trim() }
        val parsedNumbers = parts.mapNotNull { it.toIntOrNull() }

        if (parts.isNotEmpty() && parsedNumbers.size == parts.size) {
            // Режим обработки чисел
            return mapOf(
                "sum" to parsedNumbers.sum(),
                "average" to parsedNumbers.average(),
                "count" to parsedNumbers.size,
                "sorted" to parsedNumbers.sorted()
            )
        }

        // Текстовый режим: разбиваем по пробельным символам
        val words = trimmed.split(Regex("\\s+")).filter { it.isNotEmpty() }
        val longestWord = words.maxByOrNull { it.length } ?: ""
        val charCountWithoutSpaces = trimmed.filterNot { it.isWhitespace() }.length

        return mapOf(
            "wordCount" to words.size,
            "longestWord" to longestWord,
            "charCount" to charCountWithoutSpaces
        )
    }
}
