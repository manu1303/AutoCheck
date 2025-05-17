package com.example.autocheck.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.autocheck.R

@Composable
fun MyVehiclesScreen(navController: NavHostController) {
    Column(modifier = Modifier.fillMaxSize()) {

        // Encabezado amarillo con botón de regreso y título
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(136.dp)
                    .background(Color(0xFFF9BA32)),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Mis Autos",
                color = Color(0xFF2F2F31),
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp
            )

            IconButton(
                onClick = { navController.navigate("home") },
                modifier = Modifier.align(Alignment.CenterStart).padding(start = 8.dp)
            ) {
                Image(
                        painter = painterResource(R.drawable.back_arrow),
                        contentDescription = "Agregar vehículo",
                        modifier = Modifier.size(24.dp) // ajusta el tamaño del ícono
                )
            }
        }

        Column(
            modifier = Modifier
                .weight(1f)
                .padding(16.dp)
        ) {
            Spacer(modifier = Modifier.height(16.dp))

            // Título
            Text(
                text = "Mis Autos",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = Modifier.padding(horizontal = 0.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Contenedor del botón "+"
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(167.dp)
                    .padding(vertical = 8.dp)
                    .border(1.dp, Color.LightGray, RoundedCornerShape(12.dp)),
                contentAlignment = Alignment.Center
            ) {
                IconButton(onClick = {
                    // Acción para agregar nuevo vehículo
                    navController.navigate("add_vehicle")
                }) {
                    Image(
                        painter = painterResource(R.drawable.add),
                        contentDescription = "Agregar vehículo",
                        modifier = Modifier.size(40.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Texto centrado si no hay autos
            Text(
                text = "Aún no has agregado ningún vehículo. Toca el botón “+” para registrar el primero.",
                color = Color(0xFFC7C7C7),
                fontSize = 14.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
            )

        }
        //Spacer(modifier = Modifier.height(1f))

        // Pie de navegación
        BottomNavigationBar(navController = navController, selectedItem = "mis_autos")
    }
}