package com.example.profile.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.profile.data.User
import com.example.profile.ui.components.ActionButtons
import com.example.profile.ui.components.Avatar
import com.example.profile.ui.components.ProfileInfo

/**
 * Основной экран профиля пользователя на Jetpack Compose.
 *
 * Объединяет компоненты аватара, информации, интерактивного редактирования имени,
 * кнопок подписки/сброса, счётчика нажатий и переключателя темы оформления.
 *
 * @param initialUser Начальные данные пользователя (по умолчанию стандартный [User]).
 * @param isDarkTheme Текущее состояние тёмной темы.
 * @param onThemeChange Callback-обработчик переключения темы.
 * @param modifier Модификатор контейнера экрана.
 *
 * @author Мухамеджанов Эльёр Тимурович (ПИН-б-о-24-1 (2))
 * @version 1.0
 * @since 2026-09-03
 */
@Composable
fun ProfileScreen(
    initialUser: User = User(),
    isDarkTheme: Boolean = false,
    onThemeChange: (Boolean) -> Unit = {},
    modifier: Modifier = Modifier
) {
    // Состояние пользователя
    var user by remember { mutableStateOf(initialUser) }

    // Состояние поля ввода имени
    var editableName by remember { mutableStateOf(user.name) }

    // Состояние интерактивного счётчика нажатий
    var clickCount by remember { mutableIntStateOf(0) }

    val scrollState = rememberScrollState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(horizontal = 20.dp, vertical = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Переключатель темы (бонусное задание на «Отлично»)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = if (isDarkTheme) Icons.Default.DarkMode else Icons.Default.LightMode,
                contentDescription = "Тема оформления",
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier.size(20.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = if (isDarkTheme) "Тёмная" else "Светлая",
                style = MaterialTheme.typography.bodyMedium
            )
            Spacer(modifier = Modifier.width(8.dp))
            Switch(
                checked = isDarkTheme,
                onCheckedChange = onThemeChange
            )
        }

        Spacer(modifier = Modifier.height(4.dp))

        // Аватар
        Avatar()

        // Текстовая информация о профиле
        ProfileInfo(user = user)

        // Поле редактирования имени пользователя
        OutlinedTextField(
            value = editableName,
            onValueChange = { newName ->
                editableName = newName
                user = user.copy(name = newName)
            },
            label = { Text("Имя пользователя") },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Edit,
                    contentDescription = "Редактировать имя"
                )
            },
            singleLine = true,
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier.fillMaxWidth()
        )

        // Разделитель разделов
        HorizontalDivider(
            thickness = 1.dp,
            color = MaterialTheme.colorScheme.outlineVariant,
            modifier = Modifier.padding(vertical = 4.dp)
        )

        // Кнопки действий: Подписка и Сброс
        ActionButtons(
            isSubscribed = user.isSubscribed,
            onSubscribeClick = {
                val newSubscribed = !user.isSubscribed
                val newFollowers = if (newSubscribed) user.followers + 1 else user.followers - 1
                user = user.copy(
                    isSubscribed = newSubscribed,
                    followers = newFollowers
                )
            },
            onResetClick = {
                user = initialUser
                editableName = initialUser.name
                clickCount = 0
            }
        )

        // Карточка счётчика нажатий
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceVariant
            )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Интерактивный счётчик",
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.7f)
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Количество нажатий: $clickCount",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )

                Spacer(modifier = Modifier.height(12.dp))

                FilledTonalButton(
                    onClick = { clickCount++ },
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Увеличить"
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(text = "Увеличить (+1)")
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ProfileScreenPreview() {
    MaterialTheme {
        ProfileScreen()
    }
}
