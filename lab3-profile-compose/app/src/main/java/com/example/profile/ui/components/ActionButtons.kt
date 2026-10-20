package com.example.profile.ui.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.PersonAdd
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * Компонент с управляющими кнопками действий.
 *
 * Содержит кнопку подписки с плавной сменой цвета и масштаба (анимация на оценку «Отлично»),
 * а также кнопку сброса параметров экрана к исходным значениям.
 *
 * @param isSubscribed Текущий статус подписки пользователя.
 * @param onSubscribeClick Обработчик нажатия на кнопку подписки.
 * @param onResetClick Обработчик нажатия на кнопку сброса.
 * @param modifier Модификатор для внешнего контейнера кнопок.
 *
 * @author Мухамеджанов Эльёр Тимурович (ПИН-б-о-24-1 (2))
 * @version 1.0
 * @since 2026-09-03
 */
@Composable
fun ActionButtons(
    isSubscribed: Boolean,
    onSubscribeClick: () -> Unit,
    onResetClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    // Анимированная смена цвета фона кнопки подписки
    val animatedContainerColor by animateColorAsState(
        targetValue = if (isSubscribed) {
            MaterialTheme.colorScheme.tertiary
        } else {
            MaterialTheme.colorScheme.primary
        },
        label = "subscribeButtonColor"
    )

    // Анимированное масштабирование при переключении состояния
    val animatedScale by animateFloatAsState(
        targetValue = if (isSubscribed) 1.02f else 1.0f,
        animationSpec = spring(dampingRatio = 0.6f),
        label = "subscribeButtonScale"
    )

    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        // Кнопка подписки / отписки
        Button(
            onClick = onSubscribeClick,
            shape = RoundedCornerShape(14.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = animatedContainerColor
            ),
            modifier = Modifier
                .weight(1f)
                .scale(animatedScale)
                .height(48.dp)
        ) {
            Icon(
                imageVector = if (isSubscribed) Icons.Default.Check else Icons.Default.PersonAdd,
                contentDescription = null,
                modifier = Modifier.size(18.dp)
            )
            Spacer(modifier = Modifier.width(6.dp))
            Text(text = if (isSubscribed) "Отписаться" else "Подписаться")
        }

        // Кнопка сброса
        OutlinedButton(
            onClick = onResetClick,
            shape = RoundedCornerShape(14.dp),
            modifier = Modifier
                .weight(0.8f)
                .height(48.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Refresh,
                contentDescription = "Сброс",
                modifier = Modifier.size(18.dp)
            )
            Spacer(modifier = Modifier.width(6.dp))
            Text(text = "Сброс")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ActionButtonsPreview() {
    ActionButtons(
        isSubscribed = false,
        onSubscribeClick = {},
        onResetClick = {}
    )
}
