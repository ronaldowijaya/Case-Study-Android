package com.example.casestudy1

sealed class Screen(val route: String){
    object  Home: Screen(route = "home_screen")
    object  Scan: Screen(route = "scan_screen")
//    object  Pay: Screen(route = "pay_screen")
//    object  History: Screen(route = "history_screen")
}
