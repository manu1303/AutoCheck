package com.example.autocheck.views

import android.widget.Button
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.autocheck.R
import kotlinx.coroutines.delay
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment


@Composable
fun SplashScreen(navController: NavHostController) {
    var stage by remember { mutableStateOf(0) }

    LaunchedEffect(Unit) {
        delay(1000)
        stage = 1
        delay(1500)
        stage = 2
        delay(1500)
        stage = 3
    }

    when (stage) {
        0 -> EmptySplash()
        1 -> LogoSplash()
        2 -> BackgroundSplash(showLogo = false)
        3 -> BackgroundSplash(showLogo = true) {
            navController.navigate("home") {
                popUpTo("splash") { inclusive = true }
            }
        }
    }
}

@Composable
fun EmptySplash() {
    Box(modifier = Modifier.fillMaxSize().background(Color.White))
}

@Composable
fun LogoSplash() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = painterResource(R.drawable.logo_autocheck), contentDescription = null,
                modifier = Modifier.size(400.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))
        Spacer(modifier = Modifier.height(32.dp))
        Text("Confianza en cada kilómetro", modifier = Modifier.align(Alignment.CenterHorizontally))
    }
}

@Composable
fun BackgroundSplash(showLogo: Boolean, onClick: (() -> Unit)? = null) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        Image(
            painter = painterResource(R.drawable.montero),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.matchParentSize()
        )

        if (showLogo) {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally

            ) {
                Image(painter = painterResource(R.drawable.autocheck), contentDescription = null,
                    modifier = Modifier
                        .width(400.dp)
                        .height(200.dp)
                )
                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    androidx.compose.material3.Button (
                        modifier = Modifier
                            .height(59.dp)
                            .fillMaxWidth(),

                        onClick = { onClick?.invoke() },
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2F2F31)),
                        shape = RoundedCornerShape(20)
                    ) {
                        Text("Explorar AutoCheck", color = Color(0xFFF9BA32), fontSize = 24.sp)
                    }
                    Spacer(modifier = Modifier.height(60.dp))
                    Text("Confianza en cada kilómetro", color = Color.White, fontSize = 12.sp)
                }
            }
        }
    }
}