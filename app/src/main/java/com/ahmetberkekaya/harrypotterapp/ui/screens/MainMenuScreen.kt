package com.ahmetberkekaya.harrypotterapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import backgroundGradient
import coil.compose.rememberAsyncImagePainter

@Composable
fun MainMenuScreen(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = backgroundGradient) // Arka plan gradienti
    ) {
        // Harry Potter temalı arka plan resmi
        Image(
            painter = rememberAsyncImagePainter("https://tr.web.img2.acsta.net/pictures/bzp/01/29276.jpg"), // Resmin URL'sini buraya koy
            contentDescription = "Harry Potter Background",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop // Resmin tam ekran olarak yayılmasını sağlıyoruz
        )

        // İçeriği ortalamak için Box kullanıyoruz
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Harry Potter başlığı
            Text(
                text = "Harry Potter Karakterleri",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.padding(bottom = 32.dp)
            )

            // Buton
            Button(
                onClick = { navController.navigate("characterList") },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2E1E3A)),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .padding(16.dp)
                    .height(50.dp)
            ) {
                Text(
                    text = "Karakterleri Listele",
                    fontSize = 18.sp,
                    color = Color.White
                )
            }
        }
    }
}

