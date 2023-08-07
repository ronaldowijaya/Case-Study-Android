package com.example.casestudy2.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.casestudy2.data.remote.model.Details
import com.example.casestudy2.domain.item.PromoItem
import androidx.compose.runtime.livedata.observeAsState

@Composable
fun HomeScreen(homeViewModel: HomeViewModel, navController: NavController ) {
//    val homeViewModel = viewModel(modelClass = HomeViewModel::class.java)
//    val promos by homeViewModel.promos.collectAsState()
    val promos = homeViewModel.promos.observeAsState(listOf()).value

    LazyColumn {
        items(promos) { promo: PromoItem ->
            PromoCard(promo = promo, navController)
        }
    }
}

@Composable
fun PromoCard(promo: PromoItem, navController: NavController) {
    val image = rememberImagePainter(data = promo.img.url)
    Card(
        shape = RoundedCornerShape(5.dp),
        modifier = Modifier
            .padding(top = 5.dp, bottom = 5.dp, start = 10.dp, end = 10.dp)
            .fillMaxSize()
            .clickable {
                navController.navigate("details" + "/${promo.id}")
            }
    ) {
        Column {
            Image(
                painter = image,
                contentDescription = null,
                /*contentScale = ContentScale.Crop,*/
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
            )
            Column(modifier = Modifier.padding(1.dp)) {
                Text(text = promo.nama, fontWeight = FontWeight.Bold)
                Text(text = promo.desc, maxLines = 3, overflow = TextOverflow.Ellipsis)
            }
        }
    }
}