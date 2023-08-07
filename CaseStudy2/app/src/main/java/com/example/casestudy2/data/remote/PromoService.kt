package com.example.casestudy2.data.remote

import com.example.casestudy2.data.remote.model.Details
import com.example.casestudy2.data.remote.model.PromoModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject


class PromoService @Inject constructor(private val promoApi: PromoApi) {
    suspend fun getPromos(): List<PromoModel> {

        return withContext(Dispatchers.IO) {
            val promos = promoApi.getPromos()
            promos.body() ?: emptyList()
        }

    }

    suspend fun getPromoById(id: Int): Details {

        return withContext(Dispatchers.IO) {
            val promo = promoApi.getPromoById(id)
            promo.body()!!
        }

    }
}