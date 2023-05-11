package com.example.countries.models


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class PostalCode(
    @SerializedName("format")
    val format: String?,
    @SerializedName("regex")
    val regex: String?
) : Parcelable