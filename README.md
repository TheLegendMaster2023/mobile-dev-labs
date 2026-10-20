# 📱 Программирование мобильных устройств

[![Kotlin](https://img.shields.io/badge/Kotlin-2.0.0-7F52FF.svg?logo=kotlin&logoColor=white)](https://kotlinlang.org/)
[![Android](https://img.shields.io/badge/Platform-Android%20API%2024%2B-3DDC84.svg?logo=android&logoColor=white)](https://developer.android.com/)
[![Jetpack Compose](https://img.shields.io/badge/UI-Jetpack%20Compose%20BOM%202024.06-4285F4.svg?logo=jetpackcompose&logoColor=white)](https://developer.android.com/jetpack/compose)
[![Material 3](https://img.shields.io/badge/Design-Material%203-757575.svg)](https://m3.material.io/)
[![Gradle](https://img.shields.io/badge/Build-Gradle%20Kotlin%20DSL-02303A.svg?logo=gradle&logoColor=white)](https://gradle.org/)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

Репозиторий практических и лабораторных работ по дисциплине **«Программирование мобильных устройств»** кафедры информационных систем и технологий.

---

## 👨‍🎓 Данные студента

- **ФИО:** Мухамеджанов Эльёр Тимурович
- **Группа:** ПИН-б-о-24-1 (2)
- **Направление подготовки:** `09.03.03 Прикладная информатика`
- **Профиль:** Разработка программно-информационных систем
- **Курс:** 3 курс, 5 семестр (осенний семестр 2026/2027 уч. год)

---

## 📑 Навигация по лабораторным работам

| № | Название лабораторной работы | Стек технологий | Исходный код | Описание | Отчёт | Статус |
|:---:|:---|:---|:---:|:---:|:---:|:---:|
| **1** | **Установка среды разработки и запуск первого приложения на Jetpack Compose** | Android, Jetpack Compose, Material3, Kotlin | [📂 Исходники](lab1-hello-compose/app/src/main/java/com/example/hello/MainActivity.kt) | [📖 README](lab1-hello-compose/README.md) | [📝 REPORT](lab1-hello-compose/REPORT.md) | `Выполнено (10/10)` ✅ |
| **2** | **Основы языка Kotlin. Решение задач** | Kotlin JVM, Null Safety, Collections, Coroutines, JUnit 5 | [📂 Исходники](lab2-kotlin-tasks/src/main/kotlin/tasks/) | [📖 README](lab2-kotlin-tasks/README.md) | [📝 REPORT](lab2-kotlin-tasks/REPORT.md) | `Выполнено (15/15)` ✅ |
| **3** | **Пользовательский интерфейс в Jetpack Compose. Базовые компоненты** | Compose Layouts, State Management, Animation, Theming | [📂 Исходники](lab3-profile-compose/app/src/main/java/com/example/profile/ui/) | [📖 README](lab3-profile-compose/README.md) | [📝 REPORT](lab3-profile-compose/REPORT.md) | `Выполнено (11.5/11.5)` ✅ |

---

## 🚀 Краткое содержание выполненных работ

### 🔹 [Лабораторная работа №1: Hello Compose](lab1-hello-compose/)
- **Цель:** развертывание окружения Android Studio, настройка Android SDK и запуск первого приложения на **Jetpack Compose**.
- **Ключевые элементы реализации:**
  - Карточка приветствия `GreetingCard` с персональными данными студента (*Мухамеджанов Эльёр Тимурович, группа ПИН-б-о-24-1 (2)*).
  - Стилизация через Material 3 и цепочки `Modifier` (тени, скругления, фоны, отступы).
  - Интерактивная кнопка со счётчиком нажатий (`remember { mutableIntStateOf(0) }`).
  - Полное KDoc-документирование и реализация `@Preview`.
- **Файлы:**
  - Код экрана: [`MainActivity.kt`](lab1-hello-compose/app/src/main/java/com/example/hello/MainActivity.kt)
  - Тема: [`Theme.kt`](lab1-hello-compose/app/src/main/java/com/example/hello/ui/theme/Theme.kt)
  - Документация: [`README.md`](lab1-hello-compose/README.md) | [`REPORT.md`](lab1-hello-compose/REPORT.md)

---

### 🔹 [Лабораторная работа №2: Kotlin Tasks](lab2-kotlin-tasks/)
- **Цель:** глубокое освоение синтаксиса языка Kotlin, механизмов Null-Safety, функциональных операций над коллекциями и корутин.
- **Ключевые элементы реализации:**
  - **Блок 1 (Базовый синтаксис):** приветствие пользователя (`greetUser`), ветвление `when` для времён года (`getSeason`), вычисление факториала с хвостовой рекурсией [`tailrec fun factorial`](lab2-kotlin-tasks/src/main/kotlin/tasks/BasicSyntax.kt).
  - **Блок 2 (Null-безопасность):** безопасный парсинг чисел [`parseIntSafe`](lab2-kotlin-tasks/src/main/kotlin/tasks/NullSafety.kt), фильтрация и удвоение `filterNonNullAndDouble`.
  - **Блок 3 (Коллекции):** средний возраст объектов `Person`, группировка слов по первой букве [`groupByFirstLetter`](lab2-kotlin-tasks/src/main/kotlin/tasks/Collections.kt), поиск самого длинного слова `findLongestWord`.
  - **Блок 4 (Корутины):** неблокирующая задержка `delayedPrint` и параллельный запуск 3 задач через `async/await` [`runParallelTasks`](lab2-kotlin-tasks/src/main/kotlin/tasks/Coroutines.kt).
  - **Задание на «Отлично»:** парсинг и агрегация пользовательского ввода [`processUserInput`](lab2-kotlin-tasks/src/main/kotlin/tasks/AdvancedTasks.kt).
  - **Тестирование:** автоматические юнит-тесты JUnit 5 в [`TasksTest.kt`](lab2-kotlin-tasks/src/test/kotlin/TasksTest.kt).
- **Файлы:**
  - Точка входа: [`Main.kt`](lab2-kotlin-tasks/src/main/kotlin/Main.kt)
  - Документация: [`README.md`](lab2-kotlin-tasks/README.md) | [`REPORT.md`](lab2-kotlin-tasks/REPORT.md)

---

### 🔹 [Лабораторная работа №3: Экран профиля на Jetpack Compose](lab3-profile-compose/)
- **Цель:** создание интерактивного экрана профиля пользователя с декомпозицией на компоненты и управлением состоянием.
- **Ключевые элементы реализации:**
  - Круглый аватар [`Avatar.kt`](lab3-profile-compose/app/src/main/java/com/example/profile/ui/components/Avatar.kt) с границей и тенью (`clip(CircleShape)`).
  - Блок информации [`ProfileInfo.kt`](lab3-profile-compose/app/src/main/java/com/example/profile/ui/components/ProfileInfo.kt) с именем, статусом и бейджем подписчиков.
  - Поле редактирования имени `OutlinedTextField` с мгновенной рекомпозицией.
  - Управляющие кнопки [`ActionButtons.kt`](lab3-profile-compose/app/src/main/java/com/example/profile/ui/components/ActionButtons.kt) с плавной анимацией смены цвета и масштаба (`animateColorAsState`, `animateFloatAsState`).
  - Реактивное изменение счётчика подписчиков (+1 / -1) и кнопка «Сброс».
  - Интерактивный счётчик кликов и переключатель светлой/тёмной темы (`Switch`).
- **Файлы:**
  - Экран: [`ProfileScreen.kt`](lab3-profile-compose/app/src/main/java/com/example/profile/ui/ProfileScreen.kt)
  - Activity: [`MainActivity.kt`](lab3-profile-compose/app/src/main/java/com/example/profile/MainActivity.kt)
  - Документация: [`README.md`](lab3-profile-compose/README.md) | [`REPORT.md`](lab3-profile-compose/REPORT.md)

---

## 📂 Структура репозитория

```
mobile-dev-labs/
├── README.md                              # Главный файл документации репозитория
├── .gitignore                             # Исключения версионного контроля
├── Лабы/                                  # Исходные методические материалы курса
│   ├── plan.md                            # Тематический план дисциплины
│   ├── 0102_lab.md                        # Методичка к ЛР №1
│   ├── 0202_lab.md                        # Методичка к ЛР №2
│   └── 0302_lab.md                        # Методичка к ЛР №3
│
├── lab1-hello-compose/                    # Лабораторная работа №1 (Android Compose)
│   ├── app/src/main/java/com/example/hello/
│   │   ├── MainActivity.kt
│   │   └── ui/theme/
│   ├── README.md
│   └── REPORT.md
│
├── lab2-kotlin-tasks/                     # Лабораторная работа №2 (Kotlin JVM)
│   ├── src/main/kotlin/
│   │   ├── Main.kt
│   │   └── tasks/
│   ├── src/test/kotlin/
│   ├── README.md
│   └── REPORT.md
│
└── lab3-profile-compose/                  # Лабораторная работа №3 (Android Compose Profile)
    ├── app/src/main/java/com/example/profile/
    │   ├── MainActivity.kt
    │   ├── data/User.kt
    │   └── ui/
    │       ├── ProfileScreen.kt
    │       ├── components/
    │       └── theme/
    ├── README.md
    └── REPORT.md
```

---

## 🛠 Инструкция по сборке и запуску

### 1. Клонирование репозитория
```bash
git clone https://github.com/TheLegendMaster2023/mobile-dev-labs.git
cd mobile-dev-labs
```

### 2. Запуск лабораторных работ на Android (ЛР №1 и ЛР №3)
1. Запустите **Android Studio** (рекомендуется версия 2024.1+).
2. Выберите пункт **Open** и откройте папку соответствующей работы: `lab1-hello-compose` или `lab3-profile-compose`.
3. Дождитесь автоматической загрузки зависимостей Gradle.
4. Выберите виртуальное устройство (эмулятор с API 24–34) или подключенный Android-смартфон в режиме отладки по USB.
5. Нажмите комбинацию клавиш `Shift + F10` или кнопку **Run**.

### 3. Запуск консольного проекта на Kotlin (ЛР №2)
```bash
cd lab2-kotlin-tasks

# Запуск демонстрации всех решений в консоли:
./gradlew run

# Запуск модульных тестов:
./gradlew test
```

---

## 📚 Методическое обеспечение
- [Тематический план курса](Лабы/plan.md)
- [Методические указания к лабораторной работе №1](Лабы/0102_lab.md)
- [Методические указания к лабораторной работе №2](Лабы/0202_lab.md)
- [Методические указания к лабораторной работе №3](Лабы/0302_lab.md)
- [Официальная документация Android Developers](https://developer.android.com/)
- [Официальный портал языка Kotlin](https://kotlinlang.org/)
- [Руководство по Jetpack Compose](https://developer.android.com/jetpack/compose)

---

## 📄 Лицензия
Проект распространяется под открытой лицензией [MIT License](LICENSE).
Работы выполнены в образовательных целях в рамках учебного процесса.
