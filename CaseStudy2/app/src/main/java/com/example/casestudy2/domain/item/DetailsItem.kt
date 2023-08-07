package com.example.casestudy2.domain.item

import com.example.casestudy2.data.remote.model.Details
import com.example.casestudy2.data.remote.model.Img
import com.example.casestudy2.data.remote.model.PromoModel

data class DetailsItem(
    val id: Int,
    val nama: String,
    val desc: String,
    val img: Img
)

fun Details.toSpecificPromoItem() = DetailsItem(id,nama,desc,img)