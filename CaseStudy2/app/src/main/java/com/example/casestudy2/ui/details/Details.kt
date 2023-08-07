package com.example.casestudy2.ui.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.casestudy2.data.remote.model.Details
import com.example.casestudy2.domain.item.PromoItem
import com.example.casestudy2.ui.home.HomeViewModel
import com.example.casestudy2.ui.home.PromoCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(id: String, detailsViewModel: HomeViewModel, navController: NavController) {
//    detailsViewModel.getPromoById(id.toInt())
//    val detailsViewModel = viewModel(modelClass = HomeViewModel::class.java)
//    val promo by detailsViewModel.promo.collectAsState()
    val promos = detailsViewModel.promos.observeAsState(listOf()).value
    val promo = searchById(id.toInt(), promos)


//    val promo = detailsViewModel.promo.observeAsState().value

    /*LazyColumn {
        item(promo) { promo: PromoItem ->
            PromoCardDetail(promo = promo, navController)
        }
    }*/
    LazyColumn{
        item {
            val image = rememberImagePainter(data = promo?.img?.url)
            Column {
                TopAppBar(
                    navigationIcon = {
                        IconButton(onClick = { navController.popBackStack() }) {
                            Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = null)
                        }
                    },
                    title = {
                        Text(text = promo?.nama ?: "", fontWeight = FontWeight.Bold)
                    }
                )

                Image(
                    painter = image,
                    contentDescription = promo?.nama,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .clip(shape = RoundedCornerShape(8.dp))
                        .background(Color.Gray)
                )
                Text(
                    text = promo?.nama ?: "",
                    style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold),
                    modifier = Modifier.padding(vertical = 8.dp)
                )

                Text(
                    text = promo?.desc ?: "",
                    style = TextStyle(fontSize = 16.sp),
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }
        }
    }
}

@Composable
fun searchById(idToFind: Int, itemList: List<PromoItem>): PromoItem? {
    return itemList.find { it.id == idToFind }
}


/*
@Composable
fun PromoCardDetail(promo: PromoItem, navController: NavController) {
    val image = rememberImagePainter(data = promo.img.url)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Image(
            painter = image,
            contentDescription = promo.nama,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .clip(shape = RoundedCornerShape(8.dp))
                .background(Color.Gray)
        )

        Text(
            text = promo.nama,
            style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(vertical = 8.dp)
        )

        Text(
            text = promo.desc,
            style = TextStyle(fontSize = 16.sp),
            modifier = Modifier.padding(vertical = 8.dp)
        )
    }
}
*/
