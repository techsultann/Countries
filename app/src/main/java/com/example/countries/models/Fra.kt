package com.example.countries.models


import com.google.gson.annotations.SerializedName

data class Fra(
    @SerializedName("f")
    val f: String?,
    @SerializedName("m")
    val m: String?
)