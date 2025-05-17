package com.example.autocheck.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
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
fun VehicleDetailScreen(navController: NavHostController) {
    Column(modifier = Modifier.fillMaxSize()) {

        // Encabezado
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(136.dp)
                .background(Color(0xFFF9BA32)),
            contentAlignment = Alignment.Center
        ) {
            Text("Toyota Corolla", color = Color.Black, fontSize = 24.sp, fontWeight = FontWeight.Bold)

            IconButton(
                onClick = { navController.navigate("mis_autos") },
                modifier = Modifier.align(Alignment.CenterStart).padding(start = 8.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.back_arrow),
                    contentDescription = "volver",
                    modifier = Modifier.size(24.dp) // ajusta el tamaño del ícono
                )
            }

        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Toyota Corolla",
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        // Placa
        Text(
            text = "ABC - 123",
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Fila con datos rápidos
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .border(1.dp, Color.LightGray, RoundedCornerShape(12.dp))
                    .padding(12.dp)
            ) {
                Column {
                    Text("75000 Km", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                    Text("2025", color = Color.Gray)
                }
            }

            Box(
                modifier = Modifier
                    .weight(1f)
                    .border(1.dp, Color.LightGray, RoundedCornerShape(12.dp))
                    .padding(12.dp)
            ) {
                Column {
                    Text("Último mantenimiento", fontSize = 14.sp, fontWeight = FontWeight.Medium)
                    Text("29 de marzo 2025", fontSize = 14.sp, color = Color.Gray)
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Mantenimientos realizados
        Text(
            text = "Mantenimientos realizados",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(horizontal = 24.dp)
        )

        Spacer(modifier = Modifier.height(12.dp))

        // Área vacía

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(90.dp)
                .padding(vertical = 8.dp)
                .border(1.dp, Color.LightGray, RoundedCornerShape(12.dp)),
            contentAlignment = Alignment.Center
        ) {
            IconButton(onClick = {
                // Acción para agregar nuevo vehículo
                navController.navigate("add_mainteinance")
            }) {
                Image(
                    painter = painterResource(R.drawable.add),
                    contentDescription = "Agregar vehículo",
                    modifier = Modifier.size(40.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            "Aún no has agregado ningún mantenimiento. Toca el botón “+” o Agregar mantenimiento para registrar el primero.",
            color = Color.Gray,
            fontSize = 14.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(16.dp),


        )

        Spacer(modifier = Modifier.weight(1f))

        // Botón para agregar mantenimiento
        Button(
            onClick = {
                navController.navigate("agregar_mantenimiento")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .height(59.dp)
                .width(400.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2F2F31)),
            shape = RoundedCornerShape(20.dp)
        ) {
            Text("Agregar mantenimiento", color = Color(0xFFF9BA32), fontSize = 20.sp)
        }

        Spacer(modifier = Modifier.weight(1f))
        BottomNavigationBar(navController = navController)
    }
}
