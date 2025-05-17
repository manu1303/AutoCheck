package com.example.autocheck.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.autocheck.R

@Composable
fun SettingsScreen(navController: NavHostController) {
    var darkMode by remember { mutableStateOf(true) }
    var acceptUnknown by remember { mutableStateOf(false) }

    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController = navController, selectedItem = "ajustes")
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(24.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFF1F1F1F), RoundedCornerShape(16.dp))
                    .padding(24.dp)
            ) {
                //
                Column {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(id = R.drawable.profile_icon),
                        contentDescription = "Foto de perfil",
                        modifier = Modifier
                            .size(48.dp)
                            .clip(CircleShape)
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    Column {
                        Text("Zareen Wirth", color = Color.White, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                        Text(
                            "wirthzareen@example.com",
                            color = Color.LightGray,
                            fontSize = 14.sp,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }

                }
                }

                Divider(color = Color.Gray, thickness = 0.5.dp, modifier = Modifier.padding(vertical = 16.dp))

                // Opción: Modo Oscuro
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            painter = painterResource(id = R.drawable.moon),
                            contentDescription = "Modo oscuro",
                            modifier = Modifier.size(24.dp)
                        )
                        Spacer(modifier = Modifier.width(12.dp))
                        Text("Modo Oscuro", color = Color.White)
                    }
                    Switch(
                        checked = darkMode,
                        onCheckedChange = { darkMode = it },
                        colors = SwitchDefaults.colors(
                            checkedThumbColor = Color(0xFFF9BA32)
                        )
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Opción: Salir
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(id = R.drawable.exit),
                        contentDescription = "Salir",
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    Text("Salir", color = Color.White)
                }

                Divider(color = Color.Gray, thickness = 0.5.dp, modifier = Modifier.padding(vertical = 16.dp))

                // Opción: Mesa de ayuda
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(id = R.drawable.help),
                        contentDescription = "Mesa de Ayuda",
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    Text("Mesa de Ayuda", color = Color.White)
                }

                Spacer(modifier = Modifier.height(24.dp))

                // Switch final
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column {
                        Text("Aceptar mensajes desconocido", color = Color.White)
                        Text(
                            "Solo personas que conozcas",
                            fontSize = 12.sp,
                            color = Color.Gray
                        )
                    }

                    Switch(
                        checked = acceptUnknown,
                        onCheckedChange = { acceptUnknown = it },
                        colors = SwitchDefaults.colors(
                            checkedThumbColor = Color(0xFFF9BA32)
                        )
                    )
                }
            }
        }
    }
}


