package com.example.countries.models


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

@Parcelize
data class Translations(
    @SerializedName("ara")
    val ara: @RawValue Ara?,
    @SerializedName("bre")
    val bre: @RawValue Bre?,
    @SerializedName("cym")
    val cym: @RawValue Cym?,
    @SerializedName("per")
    val per: @RawValue Per?
) : Parcelable