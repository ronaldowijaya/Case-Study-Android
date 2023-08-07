package com.example.casestudy2.domain

import com.example.casestudy2.domain.item.ImgItem
import com.example.casestudy2.repo.ImgRepository
import javax.inject.Inject

class GetImgsUseCase @Inject constructor(private val imgRepository: ImgRepository) {
    suspend operator fun invoke(): List<ImgItem> {

        return imgRepository.getImgs().shuffled()

    }
}