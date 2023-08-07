package com.example.casestudy3.models

import kotlinx.serialization.Serializable

@Serializable
data class Data(
    val `data`: List<DataX>,
    val label: String,
    val percentage: String
)