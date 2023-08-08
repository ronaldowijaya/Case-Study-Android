package com.example.casestudy1.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.casestudy1.Screen
import com.example.casestudy1.model.Saldo
import com.example.casestudy1.model.TransHistory
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.casestudy1.MyViewModel
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.text.style.TextAlign

@Composable
fun HistoryScreen(
    /*navController: NavController*/
    viewModel: MyViewModel = viewModel()
){
    /*var trans by remember {
        mutableStateOf("")
    }*/
    var trans = viewModel.trans.value
//    var trans = viewModel.trans.observeAsState(listOf()).value
    var transSize = countTransHistorySize(trans) - 4
    LazyColumn {
            items(transSize) {
                Card(
                    shape = RoundedCornerShape(5.dp),
                    modifier = Modifier
                        .padding(top = 5.dp, bottom = 5.dp, start = 10.dp, end = 10.dp)
                        .fillMaxSize()
                ) {
                    Column {
                        Column(modifier = Modifier.padding(1.dp)) {
                            Text(text = "Nama Merchant: "  + trans.namaMerchant, fontWeight = FontWeight.Bold)
                            Text(text = "Nominal Transaksi: " + trans.transAmount, fontWeight = FontWeight.Bold)
                        }
                    }
                }
            }
        }

}

@Composable
fun countTransHistorySize(trans: TransHistory): Int {
    // Count the number of properties in the TransHistory class
    return trans.javaClass.declaredFields.size
}