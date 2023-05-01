package com.example.countries.models


import com.google.gson.annotations.SerializedName

data class ETB(
    @SerializedName("name")
    val name: String?,
    @SerializedName("symbol")
    val symbol: String?
)