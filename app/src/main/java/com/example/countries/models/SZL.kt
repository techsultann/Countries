package com.example.countries.models


import com.google.gson.annotations.SerializedName

data class SZL(
    @SerializedName("name")
    val name: String?,
    @SerializedName("symbol")
    val symbol: String?
)