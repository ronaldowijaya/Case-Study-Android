package com.example.casestudy2.repo

import com.example.casestudy2.data.remote.ImgService
import com.example.casestudy2.domain.item.ImgItem
import com.example.casestudy2.domain.item.toImgItem
import javax.inject.Inject

class ImgRepository @Inject constructor(private val imgService: ImgService) {
    suspend fun getImgs(): List<ImgItem> {

        return imgService.getImgs().map {
            it.toImgItem()
        }
    }
}
