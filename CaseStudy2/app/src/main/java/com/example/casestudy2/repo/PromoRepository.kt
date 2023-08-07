package com.example.casestudy2.repo

import com.example.casestudy2.data.remote.PromoService
import com.example.casestudy2.data.remote.model.Details
import com.example.casestudy2.domain.item.DetailsItem
import com.example.casestudy2.domain.item.toPromoItem
import com.example.casestudy2.domain.item.toSpecificPromoItem
import javax.inject.Inject

class PromoRepository @Inject constructor(private val promoService: PromoService) {
    suspend fun getPromos(): List<com.example.casestudy2.domain.item.PromoItem> {

        return promoService.getPromos().map {
            it.toPromoItem()
        }
    }
    suspend fun getPromoById(id: Int): DetailsItem {

        return promoService.getPromoById(id).toSpecificPromoItem()

    }
}