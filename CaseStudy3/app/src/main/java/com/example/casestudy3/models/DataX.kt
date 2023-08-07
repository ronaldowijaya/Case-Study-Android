package com.example.casestudy3.models

import kotlinx.serialization.Serializable

@Serializable
data class DataX(
    val nominal: Int,
    val trx_date: String
)