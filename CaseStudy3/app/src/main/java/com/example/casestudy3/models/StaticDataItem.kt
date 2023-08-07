package com.example.casestudy3.models

import kotlinx.serialization.Serializable

@Serializable
data class StaticDataItem(
    val `data`: List<Data>,
    val type: String
)