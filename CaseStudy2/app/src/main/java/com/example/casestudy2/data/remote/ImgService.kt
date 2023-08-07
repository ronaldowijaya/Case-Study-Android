package com.example.casestudy2.data.remote;

import com.example.casestudy2.data.remote.model.Img
import kotlinx.coroutines.withContext


import javax.inject.Inject

import kotlinx.coroutines.Dispatchers

class ImgService @Inject constructor(private val promoApi: PromoApi) {
    suspend fun getImgs(): List<Img> {

        return withContext(Dispatchers.IO) {
            val imgs = promoApi.getImgs()
            imgs.body() ?: emptyList()
        }

    }
}
