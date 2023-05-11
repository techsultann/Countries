package com.example.countries.models


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class NPR(
    @SerializedName("name")
    val name: String?,
    @SerializedName("symbol")
    val symbol: String?
) : Parcelable