package com.example.countries.models


import com.google.gson.annotations.SerializedName

data class KYD(
    @SerializedName("name")
    val name: String?,
    @SerializedName("symbol")
    val symbol: String?
)