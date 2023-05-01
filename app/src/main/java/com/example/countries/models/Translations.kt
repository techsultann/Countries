package com.example.countries.models


import com.google.gson.annotations.SerializedName

data class Translations(
    @SerializedName("ara")
    val ara: Ara?,
    @SerializedName("bre")
    val bre: Bre?,
    @SerializedName("cym")
    val cym: Cym?,
    @SerializedName("per")
    val per: Per?
)