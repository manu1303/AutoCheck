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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.compose.material3.OutlinedTextField
import androidx.compose.ui.res.painterResource
import com.example.autocheck.R


@Composable
fun AddVehicleScreen(navController: NavHostController) {
    var marca by remember { mutableStateOf("") }
    var modelo by remember { mutableStateOf("") }
    var anio by remember { mutableStateOf("") }
    var placa by remember { mutableStateOf("") }
    var kilometraje by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize()) {

        // Encabezado
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(136.dp)
                .background(Color(0xFFF9BA32)),
            contentAlignment = Alignment.Center
        ) {
            Text("Agregar", color = Color(0xFF2F2F31), fontSize = 24.sp, fontWeight = FontWeight.Bold)

            IconButton(
                onClick = { navController.navigate("mis_autos") },
                modifier = Modifier.align(Alignment.CenterStart).padding(start = 8.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.back_arrow),
                    contentDescription = "Volver",
                    modifier = Modifier.size(24.dp) // ajusta el tamaño del ícono
                )
            }

        }

        Spacer(modifier = Modifier.height(24.dp))

        // Título
        Text(
            "Agregar nuevo vehículo",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Campos de texto
        Column(modifier = Modifier.padding(horizontal = 16.dp)) {
            OutlinedTextField(
                value = marca,
                onValueChange = { marca = it },
                label = { Text("Marca") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(12.dp))

            OutlinedTextField(
                value = modelo,
                onValueChange = { modelo = it },
                label = { Text("Modelo") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(12.dp))

            OutlinedTextField(
                value = anio,
                onValueChange = { anio = it },
                label = { Text("Año") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(12.dp))

            OutlinedTextField(
                value = placa,
                onValueChange = { placa = it },
                label = { Text("Placa") },
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
        }

        Spacer(modifier = Modifier.height(32.dp))

        // Botón para guardar vehículo
        Button(
            onClick = {
                // Guardar vehículo (puedes conectar con Firebase aquí)
                navController.navigate("vehiculo_guardado") // Navega a siguiente pantalla
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .height(59.dp)
                .width(400.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2F2F31)),
            shape = RoundedCornerShape(20.dp)
        ) {
            Text("Guardar vehículo", color = Color(0xFFF9BA32), fontSize = 20.sp)
        }
        Spacer(modifier = Modifier.weight(1f))
        BottomNavigationBar(navController = navController)
    }
}
