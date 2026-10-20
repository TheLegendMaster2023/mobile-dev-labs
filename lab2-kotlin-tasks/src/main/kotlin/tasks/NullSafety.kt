package tasks

/**
 * Блок задач по механизмам null-безопасности (Null Safety) в Kotlin.
 *
 * @author Мухамеджанов Эльёр Тимурович (ПИН-б-о-24-1 (2))
 * @version 1.0
 * @since 2026-09-03
 */
object NullSafety {

    /**
     * Задача 2.1. Безопасное преобразование строки в целое число.
     *
     * Использует стандартную функцию безопасного парсинга [toIntOrNull].
     * Если строка равна null или не может быть преобразована в число, возвращает null.
     *
     * @param str Исходная строка (может быть null).
     * @return Целое число [Int] или `null`.
     *
     * Пример: `parseIntSafe("123")` -> `123`
     * Пример: `parseIntSafe("abc")` -> `null`
     * Пример: `parseIntSafe(null)` -> `null`
     */
    fun parseIntSafe(str: String?): Int? {
        return str?.toIntOrNull()
    }

    /**
     * Задача 2.2. Фильтрация null-элементов и удвоение значений списка.
     *
     * Применяет цепочку функций высшего порядка: [filterNotNull] для исключения null-значений
     * и [map] для умножения каждого оставшегося числа на 2.
     *
     * @param list Исходный список, допускающий null-элементы.
     * @return Новый список без null-элементов, где каждое число удвоено.
     *
     * Пример: `filterNonNullAndDouble(listOf(1, null, 3, null, 5))` -> `[2, 6, 10]`
     */
    fun filterNonNullAndDouble(list: List<Int?>): List<Int> {
        return list.filterNotNull().map { it * 2 }
    }
}
