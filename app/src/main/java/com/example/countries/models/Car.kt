package com.example.countries.models


import com.google.gson.annotations.SerializedName

data class Car(
    @SerializedName("side")
    val side: String?,
    @SerializedName("signs")
    val signs: List<String?>?
)