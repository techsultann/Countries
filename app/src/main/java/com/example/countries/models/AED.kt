package com.example.countries.models


import android.os.Parcelable
import com.google.gson.annotations.SerializedName

@kotlinx.parcelize.Parcelize
data class AED(
    @SerializedName("name")
    val name: String?,
    @SerializedName("symbol")
    val symbol: String?
) : Parcelable