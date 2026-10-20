package com.example.profile.data

/**
 * Модель данных, представляющая профиль пользователя.
 *
 * @property name Имя пользователя.
 * @property surname Фамилия пользователя.
 * @property status Текстовый статус или описание профиля.
 * @property followers Количество подписчиков.
 * @property isSubscribed Флаг, отражающий, подписан ли текущий пользователь на данный профиль.
 *
 * @author Мухамеджанов Эльёр Тимурович (ПИН-б-о-24-1 (2))
 * @version 1.0
 * @since 2026-09-03
 */
data class User(
    val name: String = "Алексей",
    val surname: String = "Смирнов",
    val status: String = "Занимаюсь мобильной разработкой 📱",
    val followers: Int = 128,
    val isSubscribed: Boolean = false
)
