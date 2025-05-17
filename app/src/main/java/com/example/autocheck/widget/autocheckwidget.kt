package com.example.autocheck.widget

import android.content.Context
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.glance.GlanceModifier
import androidx.glance.GlanceTheme
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.provideContent
import androidx.glance.color.ColorProvider
import androidx.glance.layout.*
import androidx.glance.text.Text
import androidx.glance.text.TextStyle
import androidx.glance.text.FontWeight
import androidx.compose.ui.graphics.*
import androidx.glance.GlanceId
import androidx.glance.appwidget.cornerRadius
import androidx.glance.background

class AutoCheckWidget : GlanceAppWidget() {

    override suspend fun provideGlance(context: Context, id: GlanceId) {
        provideContent {
            GlanceTheme {
                Column(
                    modifier = GlanceModifier
                        .fillMaxSize()
                        .background(Color(0xAA2F2F31))
                        .padding(16.dp)
                        .cornerRadius(16.dp)
                ) {
                    Text(
                        text = "Toyota Corolla",
                        style = TextStyle(
                            color = ColorProvider(day = Color(0xFFF9BA32), night = Color(0xFFF9BA32)),
                            fontWeight = FontWeight.Bold, fontSize = 18.sp)
                    )

                    Text(
                        text = "ABC123",
                        style = TextStyle(
                            color = ColorProvider(day = Color(0xFF000000), night = Color(0xFFFFFFFF)),
                            fontSize = 14.sp
                        )
                    )

                    Spacer(GlanceModifier.height(8.dp))

                    Text(
                        text = "Próximo mantenimiento",
                        style = TextStyle(
                            fontSize = 14.sp,
                            color = ColorProvider(day = Color(0xFF666666), night = Color(0xFFBBBBBB))
                        )
                    )

                    Text("🛢 Cambio de aceite", style = TextStyle(fontWeight = FontWeight.Bold))

                    Text(
                        text = "15 may 2024",
                        style = TextStyle(
                            fontSize = 12.sp,
                            color = ColorProvider(day = Color(0xFF666666), night = Color(0xFFBBBBBB))
                        )
                    )

                    Spacer(GlanceModifier.height(8.dp))

                    Text(
                        text = "🔴 Urgente",
                        style = TextStyle(
                            color = ColorProvider(day = Color(0xFFFF0000), night = Color(0xFFFF6666)),
                            fontWeight = FontWeight.Bold
                        )
                    )
                }
            }
        }
    }
}
