package com.example.casestudy1.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.casestudy1.Screen

@Composable
fun HomeScreen(
    /*navController: NavController*/
){
    val saldo = 750000
    Box(
        modifier = Modifier.
            fillMaxSize(),
            contentAlignment = Alignment.Center
    ) {
        Text(
            /*modifier = Modifier.clickable {
                navController.navigate(route = Screen.Pay.route)
            },*/
            text = "Saldo Awal: " + saldo ,
            color = MaterialTheme.colorScheme.primary,
            fontSize = MaterialTheme.typography.headlineMedium.fontSize,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
@Preview(showBackground = true)
fun HomeScreenPreview(){
    HomeScreen(
        /*navController = rememberNavController()*/
    )
}