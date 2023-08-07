package com.example.casestudy2.domain.item

import com.example.casestudy2.data.remote.model.Img
import com.example.casestudy2.data.remote.model.PromoModel

data class PromoItem(
    val id: Int,
    val nama: String,
//    val alt: String,
//    val count: Int,
//    val createdAt: String,
//    val created_at: String,
    val desc: String,
    val img: Img
//    val lokasi: String,
//    val published_at: String,
//    val updated_at: String
)

//fun PromoModel.toPromoItem() = PromoItem(id, nama, alt, count, createdAt, created_at, desc, img, lokasi, published_at, updated_at)
fun PromoModel.toPromoItem() = PromoItem(id,nama,desc,img)