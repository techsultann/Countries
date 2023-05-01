package com.example.countries.models


import com.google.gson.annotations.SerializedName

data class GGP(
    @SerializedName("name")
    val name: String?,
    @SerializedName("symbol")
    val symbol: String?
)