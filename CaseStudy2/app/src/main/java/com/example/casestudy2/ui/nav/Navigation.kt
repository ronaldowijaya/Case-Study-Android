package com.example.casestudy2.ui.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.casestudy2.ui.details.DetailScreen
import com.example.casestudy2.ui.home.HomeScreen
import com.example.casestudy2.ui.home.HomeViewModel

@Composable
fun SetupNavHost(navController: NavHostController, homeViewModel: HomeViewModel) {
    NavHost(navController = navController, startDestination = "home") {

        composable("home") {
            HomeScreen(homeViewModel = homeViewModel, navController = navController)
        }

        composable("details" + "/{$id}") { backStackEntry ->
            DetailScreen(id = backStackEntry.arguments?.getString(id.toString())?: "1",detailsViewModel = homeViewModel, navController = navController)
        }

    }
}
