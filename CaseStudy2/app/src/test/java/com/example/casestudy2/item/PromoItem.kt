package com.example.casestudy2.item

import com.example.casestudy2.data.remote.model.Img
import com.example.casestudy2.data.remote.model.PromoModel

data class PromoItem(
    val id: Int,
    val nama: String,
    val alt: String,
    val count: Int,
    val createdAt: String,
    val created_at: String,
    val desc: String,
    val img: Img,
    val lokasi: String,
    val published_at: String,
    val updated_at: String
)

fun PromoModel.toPromoItem() = PromoItem(id, nama, alt, count, createdAt, created_at, desc, img, lokasi, published_at, updated_at)


/*
data class PromoItem(
    val developer: String,
    val freetogame_profile_url: String,
    val game_url: String,
    val genre: String,
    val id: Int,
    val platform: String,
    val publisher: String,
    val release_date: String,
    val short_description: String,
    val thumbnail: String,
    val title: String
)

fun PromoModel.toPromoItem() = PromoItem(developer, freetogame_profile_url, game_url, genre, id, platform, publisher, release_date, short_description, thumbnail, title)
*/
