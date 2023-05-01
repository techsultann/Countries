package com.example.countries.models


import com.google.gson.annotations.SerializedName

data class Her(
    @SerializedName("common")
    val common: String?,
    @SerializedName("official")
    val official: String?
)