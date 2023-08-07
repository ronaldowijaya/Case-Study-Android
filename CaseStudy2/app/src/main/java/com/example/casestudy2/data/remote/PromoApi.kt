package com.example.casestudy2.data.remote

import com.example.casestudy2.data.remote.model.Details
import com.example.casestudy2.data.remote.model.Img
import com.example.casestudy2.data.remote.model.PromoModel
import com.example.casestudy2.util.Constants.Companion.PROMOS_ENDPOINT
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface PromoApi {
    @GET(PROMOS_ENDPOINT)
    suspend fun getPromos(): Response<List<PromoModel>>
    suspend fun getImgs(): Response<List<Img>>
    suspend fun getPromoById(@Query(value = "id") id: Int): Response<Details>
}