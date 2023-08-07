package com.example.casestudy2.domain.item

import com.example.casestudy2.data.remote.model.Img
import com.example.casestudy2.data.remote.model.PromoModel

data class ImgItem(
    /*    val alternativeText: String,
        val caption: String,
        val created_at: String,
        val ext: String,
        val formats: Formats,
        val hash: String,
        val height: Int,
        val id: Int,
        val mime: String,
        val name: String,
        val provider: String,
        val size: Double,
        val updated_at: String,*/
    val url: String,
//    val width: Int
)

fun Img.toImgItem() = ImgItem(url)