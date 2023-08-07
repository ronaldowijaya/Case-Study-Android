package com.example.casestudy2.domain

import com.example.casestudy2.domain.item.DetailsItem
import com.example.casestudy2.repo.PromoRepository
import javax.inject.Inject

class GetPromosByIdUseCase @Inject constructor(private val promoRepository: PromoRepository) {
    suspend operator fun invoke(id: Int): DetailsItem {

        return promoRepository.getPromoById(id)

    }
}