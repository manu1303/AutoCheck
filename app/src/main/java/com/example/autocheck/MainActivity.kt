package com.example.autocheck

import android.os.Bundle
import android.window.SplashScreen
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.autocheck.ui.theme.AutoCheckTheme
import com.example.autocheck.views.AddMaintenanceScreen
import com.example.autocheck.views.AddVehicleScreen
import com.example.autocheck.views.CheckScreen
import com.example.autocheck.views.HomeScreen
import com.example.autocheck.views.SplashScreen
import com.example.autocheck.views.MyVehiclesScreen
import com.example.autocheck.views.SettingsScreen
import com.example.autocheck.views.VehicleDetailScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AutoCheckTheme {
                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = "splash" // Pantalla inicial
                ) {
                    composable("splash") { SplashScreen(navController) }
                    composable("home") { HomeScreen(navController) } // Sustituye por tu pantalla principal real
                    composable("mis_autos") { MyVehiclesScreen(navController) }
                    composable("add_vehicle") { AddVehicleScreen(navController) }
                    composable("vehiculo_guardado") { VehicleDetailScreen(navController)}
                    composable("agregar_mantenimiento") { AddMaintenanceScreen(navController, "check") }
                    composable("ajustes") { SettingsScreen(navController)}
                    composable("check") { CheckScreen(navController)}
                    composable("agregar_mantenimiento/from={from}") { backStackEntry ->
                        val from = backStackEntry.arguments?.getString("from") ?: "check"
                        AddMaintenanceScreen(navController, from)}

                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AutoCheckTheme {
        Greeting("Android")
    }
}