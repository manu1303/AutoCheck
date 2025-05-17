package com.example.autocheck.views


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.autocheck.R

@Composable
fun HomeScreen(navController: NavHostController) {
    Column(modifier = Modifier.fillMaxSize()) {
        // ENCABEZADO CON BOX
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(136.dp)
                .background(Color(0xFFF9BA32)),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "AutoCheck",
                color = Color(0xFF2F2F31),
                fontSize = 24.sp,
                fontWeight = androidx.compose.ui.text.font.FontWeight.Bold
            )
        }

        // CONTENIDO PRINCIPAL
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(16.dp)
        ) {
            Text("Vehículos", fontWeight = androidx.compose.ui.text.font.FontWeight.Bold, fontSize = 20.sp)

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(167.dp)
                    .padding(vertical = 8.dp)
                    .border(1.dp, Color.LightGray, RoundedCornerShape(12.dp)),
                contentAlignment = Alignment.Center
            ) {
                // Esto lo hace clickeable
                IconButton(onClick = {
                navController.navigate("mis_autos")/* Acción para agregar vehículo */ }) {
                    Image(
                        painter = painterResource(R.drawable.add),
                        contentDescription = "Agregar vehículo",
                        modifier = Modifier.size(40.dp) // ajusta el tamaño del ícono
                    )
                }
            }

            Spacer(modifier = Modifier.height(26.dp))

            Text("Próximos mantenimientos", fontWeight = androidx.compose.ui.text.font.FontWeight.Bold, fontSize = 20.sp)
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                "Cuando registres tu primer auto y sus mantenimientos, verás aquí los próximos recordatorios.",
                style = MaterialTheme.typography.bodySmall,
                color = Color(0xFFC7C7C7),
                fontSize = 14.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(vertical = 8.dp)
                    .align(Alignment.CenterHorizontally)

            )

            Spacer(modifier = Modifier.height(26.dp))

            Text("Historial de mantenimiento", fontWeight = androidx.compose.ui.text.font.FontWeight.Bold, fontSize = 20.sp)
            Spacer(modifier = Modifier.height(14.dp))
            Text(
                "Aún no hay registros. Agrega un mantenimiento para llevar el control de tu vehículo.",
                style = MaterialTheme.typography.bodySmall,
                color = Color(0xFFC7C7C7),
                fontSize = 14.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(vertical = 8.dp)
                    .align(Alignment.CenterHorizontally)
            )
        }

        // PIE DE NAVEGACIÓN
        BottomNavigationBar(navController = navController)
    }
}
