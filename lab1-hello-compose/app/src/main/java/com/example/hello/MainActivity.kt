package com.example.hello

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hello.ui.theme.HelloTheme

/**
 * Главная Activity приложения на Jetpack Compose.
 * Отображает экран с приветствием и информацией о пользователе.
 *
 * @author Мухамеджанов Эльёр Тимурович (ПИН-б-о-24-1 (2))
 * @version 1.0
 * @since 2026-09-03
 */
class MainActivity : ComponentActivity() {

    /**
     * Вызывается при создании Activity.
     * Устанавливает Compose-содержимое экрана в рамках темы [HelloTheme].
     *
     * @param savedInstanceState Сохранённое состояние экземпляра Activity (если есть).
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HelloTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GreetingCard(
                        studentName = "Мухамеджанов Эльёр Тимурович",
                        groupName = "ПИН-б-о-24-1 (2)",
                        speciality = "09.03.03 Прикладная информатика"
                    )
                }
            }
        }
    }
}

/**
 * Composable-компонент карточки студента с приветствием и интерактивным счётчиком.
 *
 * @param studentName Полное имя студента.
 * @param groupName Академическая группа.
 * @param speciality Код и наименование направления подготовки.
 * @param modifier Модификатор внешнего вида и геометрии контейнера.
 *
 * @author Мухамеджанов Эльёр Тимурович (ПИН-б-о-24-1 (2))
 * @since 2026-09-03
 */
@Composable
fun GreetingCard(
    studentName: String,
    groupName: String,
    speciality: String,
    modifier: Modifier = Modifier
) {
    var clickCount by remember { mutableIntStateOf(0) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Карточка с градиентной подложкой
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .shadow(elevation = 8.dp, shape = RoundedCornerShape(20.dp)),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceVariant
            )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Иконка
                Icon(
                    imageVector = Icons.Default.Info,
                    contentDescription = "Логотип лабораторной работы",
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier
                        .size(56.dp)
                        .padding(bottom = 12.dp)
                )

                // Заголовок приложения
                Text(
                    text = "Моё первое приложение",
                    style = MaterialTheme.typography.headlineMedium.copy(
                        fontWeight = FontWeight.ExtraBold,
                        letterSpacing = 0.5.sp
                    ),
                    color = MaterialTheme.colorScheme.primary,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(16.dp))

                HorizontalDivider(
                    thickness = 1.5.dp,
                    color = MaterialTheme.colorScheme.outlineVariant
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Данные студента
                Text(
                    text = studentName,
                    style = MaterialTheme.typography.titleLarge.copy(
                        fontWeight = FontWeight.SemiBold
                    ),
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(8.dp))

                // Блок группы с бейджем
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .background(MaterialTheme.colorScheme.primaryContainer)
                        .padding(horizontal = 12.dp, vertical = 6.dp)
                ) {
                    Text(
                        text = "Группа: $groupName",
                        style = MaterialTheme.typography.bodyMedium.copy(
                            fontWeight = FontWeight.Medium
                        ),
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = speciality,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.8f),
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(24.dp))

                // Интерактивная кнопка
                Button(
                    onClick = { clickCount++ },
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.primary
                    ),
                    modifier = Modifier.fillMaxWidth(0.85f)
                ) {
                    Icon(
                        imageVector = Icons.Default.ThumbUp,
                        contentDescription = "Иконка лайка",
                        modifier = Modifier.size(18.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "Нажми меня (Кликов: $clickCount)")
                }
            }
        }
    }
}

/**
 * Функция предпросмотра экрана приложения в редакторе Android Studio.
 */
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    HelloTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            GreetingCard(
                studentName = "Мухамеджанов Эльёр Тимурович",
                groupName = "ПИН-б-о-24-1 (2)",
                speciality = "09.03.03 Прикладная информатика"
            )
        }
    }
}
