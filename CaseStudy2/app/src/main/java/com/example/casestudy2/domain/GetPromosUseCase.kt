package com.example.casestudy2.domain

import com.example.casestudy2.domain.item.PromoItem
import com.example.casestudy2.repo.PromoRepository
import javax.inject.Inject

class GetPromosUseCase @Inject constructor(private val promoRepository: PromoRepository) {
    suspend operator fun invoke(): List<PromoItem> {

        return promoRepository.getPromos().shuffled()

    }
}