package com.example.casestudy1

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.casestudy1.screens.HistoryScreen
import com.example.casestudy1.screens.HomeScreen
import com.example.casestudy1.screens.PayScreen
import com.example.casestudy1.screens.ScanScreen

@Composable
fun BottomNavGraph(
    navController: NavHostController
){
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ){
        composable(
            route = Screen.Home.route
        ){
            HomeScreen(/*navController = navController*/)
        }
        composable(
            route = Screen.Scan.route
        ){
            ScanScreen(/*navController = navController*/)
        }
        /*composable(
                route = Screen.Pay.route
                ){
            PayScreen(*//*navController = navController*//*)
        }*/
        /*composable(
            route = Screen.History.route
        ){
            HistoryScreen(*//*navController = navController*//*)
        }*/
    }
}