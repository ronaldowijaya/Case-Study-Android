package com.example.casestudy1

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.Star
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: ImageVector
){
    object Home: BottomBarScreen(
        route = "home_screen",
        title = "Home",
        icon = Icons.Default.Home
    )
    object Scan: BottomBarScreen(
        route = "scan_screen",
        title = "Scan",
        icon = Icons.Default.Star
    )
/*    object Pay: BottomBarScreen(
        route = "pay_screen",
        title = "Pay",
        icon = Icons.Default.Send
    )*/
    /*object History: BottomBarScreen(
        route = "history_screen",
        title = "History",
        icon = Icons.Default.Notifications
    )*/
}
