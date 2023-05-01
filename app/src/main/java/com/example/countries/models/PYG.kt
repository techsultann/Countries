package com.example.countries.models


import com.google.gson.annotations.SerializedName

data class PYG(
    @SerializedName("name")
    val name: String?,
    @SerializedName("symbol")
    val symbol: String?
)