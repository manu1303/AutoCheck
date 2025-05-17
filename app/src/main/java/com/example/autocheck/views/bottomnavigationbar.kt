package com.example.autocheck.views

import androidx.compose.material3.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.*
import androidx.navigation.NavHostController
import com.example.autocheck.R

@Composable
fun BottomNavigationBar(navController: NavHostController, selectedItem: String = "casa") {
    NavigationBar(containerColor = Color(0xFF2F2F31)) {
        NavigationBarItem(
            selected = selectedItem == "casa",
            onClick = { navController.navigate("home") },
            icon = {
                Icon(
                    painter = painterResource(R.drawable.home_icon),
                    contentDescription = "Inicio",
                    modifier = Modifier.size(24.dp),// ajusta el tamaño
                    tint = Color(if (selectedItem == "casa") 0xFFF9BA32 else 0xFFC7C7C7)
                )},
            label = { Text("Casa", color = Color.White) }
        )
        NavigationBarItem(
            selected = selectedItem == "mis_autos",
            onClick = { navController.navigate("mis_autos") },
            icon = {
                Icon(
                    painter = painterResource(R.drawable.car_icon),
                    contentDescription = "Mis autos",
                    modifier = Modifier.size(26.dp),// ajusta el tamaño
                    tint = Color(if (selectedItem == "mis_autos") 0xFFF9BA32 else 0xFFC7C7C7)
                )},
                //Icon(Icons.Default.Call, contentDescription = "Mis autos", tint = Color.White) },
            label = { Text("Mis Autos", color = Color.White) }
        )
        NavigationBarItem(
            selected = selectedItem == "check",
            onClick = { navController.navigate("check")},
            icon = {
                Icon(
                    painter = painterResource(R.drawable.engine),
                    contentDescription = "Check",
                    modifier = Modifier.size(24.dp),// ajusta el tamaño
                    tint = Color(if (selectedItem == "check") 0xFFF9BA32 else 0xFFC7C7C7)
                )},
                //Icon(Icons.Default.AddCircle, contentDescription = "Agregar", tint = Color(0xFFF9BA32)) },
            label = { Text("Check", color = Color.White) }
        )
        NavigationBarItem(
            selected = selectedItem == "ajustes",
            onClick = { navController.navigate("ajustes") },
            icon = {
                Icon(
                    painter = painterResource(R.drawable.gear_icon),
                    contentDescription = "Ajustes",
                    modifier = Modifier.size(24.dp),// ajusta el tamaño
                    tint = Color(if (selectedItem == "ajustes") 0xFFF9BA32 else 0xFFC7C7C7)
                )},
                //Icon(Icons.Default.Settings, contentDescription = "Ajustes", tint = Color(0xFFF9BA32)) },
            label = { Text("Ajustes", color = Color.White) }
        )
        /*NavigationBarItem(
            selected = selectedItem == "perfil",
            onClick = { /* Navega a Perfil */ },
            icon = {
                Icon(
                    painter = painterResource(R.drawable.profile_icon),
                    contentDescription = "Perfil",
                    modifier = Modifier.size(26.dp),// ajusta el tamaño
                    tint = Color(if (selectedItem == "perfil") 0xFFF9BA32 else 0xFFC7C7C7)
                )},
                //Icon(Icons.Default.Person, contentDescription = "Perfil", tint = Color(0xFFF9BA32)) },
            label = { Text("Perfil", color = Color.White) }
        )*/
    }
}