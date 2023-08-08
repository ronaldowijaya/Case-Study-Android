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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.casestudy1.MyViewModel
import com.example.casestudy1.Screen
import com.example.casestudy1.model.Saldo
import com.example.casestudy1.model.TransHistory
import java.text.NumberFormat
import java.util.Locale


@Composable
fun HomeScreen(
    /*navController: NavController*/
    saldo: Saldo = Saldo(),
    viewModel: MyViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
){
    var trans = viewModel.trans.value

    var total = saldo.saldo - trans.transAmount
    Box(
        modifier = Modifier.
            fillMaxSize(),
            contentAlignment = Alignment.Center
    ) {
        currencyText(total).toString()
    }
}

@Composable
fun currencyText(amount: Int) {
    val format = NumberFormat.getCurrencyInstance(Locale("id", "ID"))
    val formattedAmount = format.format(amount)

    Text(
        text = "Saldo\n" + formattedAmount,
        color = MaterialTheme.colorScheme.primary,
        fontSize = MaterialTheme.typography.headlineMedium.fontSize,
        fontWeight = FontWeight.Bold
    )
}