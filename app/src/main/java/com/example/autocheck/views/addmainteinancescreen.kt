package com.example.autocheck.views


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.compose.ui.text.input.KeyboardType
import com.example.autocheck.R

@Composable
fun AddMaintenanceScreen(navController: NavHostController, from: String = "check") {
    var tipo by remember { mutableStateOf("") }
    var fecha by remember { mutableStateOf("") }
    var kilometraje by remember { mutableStateOf("") }
    var costo by remember { mutableStateOf("") }
    var notas by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize()) {

        // Encabezado
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(136.dp)
                .background(Color(0xFFF9BA32)),
            contentAlignment = Alignment.Center
        ) {
            Text("Mantenimientos", color = Color(0xFF2F2F31), fontSize = 24.sp, fontWeight = FontWeight.Bold)

            IconButton(
                onClick = {
                    navController.navigate("check")
                },
                modifier = Modifier.align(Alignment.CenterStart).padding(start = 8.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.back_arrow),
                    contentDescription = "Volver",
                    modifier = Modifier.size(24.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Título
        Text(
            "Nuevo mantenimiento",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Campos
        Column(modifier = Modifier.padding(horizontal = 16.dp)) {
            OutlinedTextField(
                value = tipo,
                onValueChange = { tipo = it },
                label = { Text("Tipo de mantenimiento") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(12.dp))

            OutlinedTextField(
                value = fecha,
                onValueChange = { fecha = it },
                label = { Text("Fecha") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(12.dp))

            OutlinedTextField(
                value = kilometraje,
                onValueChange = { kilometraje = it },
                label = { Text("Kilometraje") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(12.dp))

            OutlinedTextField(
                value = costo,
                onValueChange = { costo = it },
                label = { Text("Costo") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(12.dp))

            OutlinedTextField(
                value = notas,
                onValueChange = { notas = it },
                label = { Text("Notas") },
                modifier = Modifier.fillMaxWidth()
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        // Botón guardar
        Button(
            onClick = {
                // Aquí puedes guardar en Firebase o en memoria

                if (from == "vehicle_detail") {
                    navController.navigate("vehicle_detail") // volver al detalle del vehículo
                } else {
                    navController.navigate("mis_autos") // para elegir a qué vehículo asignar
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .height(59.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2F2F31)),
            shape = RoundedCornerShape(20.dp)
        ) {
            Text("Guardar mantenimiento", color = Color(0xFFF9BA32), fontSize = 20.sp, textAlign = TextAlign.Center)
        }

        Spacer(modifier = Modifier.weight(1f))
        BottomNavigationBar(navController = navController, selectedItem = "check")
    }
}
