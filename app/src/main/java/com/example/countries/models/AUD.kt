package com.example.countries.models


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class AUD(
    @SerializedName("name")
    val name: String?,
    @SerializedName("symbol")
    val symbol: String?
) : Parcelable