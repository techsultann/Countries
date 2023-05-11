package com.example.countries.models


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.RawValue
import kotlinx.parcelize.IgnoredOnParcel
import kotlinx.parcelize.Parcelize
import java.io.Serializable
import java.util.Currency

@Parcelize
data class CountriesResponseItem(
    @SerializedName("altSpellings")
    val altSpellings: List<String>?,
    @SerializedName("area")
    val area: Double?,
    @SerializedName("borders")
    val borders: List<String>?,
    @SerializedName("capital")
    val capital: List<String>?,
    @SerializedName("capitalInfo")
    val capitalInfo: @RawValue CapitalInfo?,
    @SerializedName("car")
    val car: @RawValue Car?,
    @SerializedName("cca2")
    val cca2: String?,
    @SerializedName("cca3")
    val cca3: String?,
    @SerializedName("ccn3")
    val ccn3: String?,
    @SerializedName("cioc")
    val cioc: String?,
    @SerializedName("coatOfArms")
    val coatOfArms: @RawValue CoatOfArms?,
    @SerializedName("continents")
    val continents: List<String>?,
    val currencies: Currencies?,
    @SerializedName("demonyms")
    val demonyms: @RawValue Demonyms?,
    @SerializedName("fifa")
    val fifa: String?,
    val flag: String?,
    @SerializedName("flags")
    val flags: @RawValue Flags?,
    @SerializedName("gini")
    val gini: @RawValue Gini?,
    @SerializedName("idd")
    val idd: @RawValue Idd?,
    @SerializedName("independent")
    val independent: Boolean?,
    @SerializedName("landlocked")
    val landlocked: Boolean?,
    val languages: HashMap<String, String>? = HashMap(),
    @SerializedName("latlng")
    val latlng: List<Double>?,
    @SerializedName("maps")
    val maps: @RawValue Maps?,
    @SerializedName("name")
    val name: @RawValue Name?,
    @SerializedName("population")
    val population: Int?,
    @SerializedName("postalCode")
    val postalCode: PostalCode?,
    @SerializedName("region")
    val region: String?,
    @SerializedName("startOfWeek")
    val startOfWeek: String?,
    @SerializedName("status")
    val status: String?,
    @SerializedName("subregion")
    val subregion: String?,
    @SerializedName("timezones")
    val timezones: List<String>?,
    @SerializedName("tld")
    val tld: List<String>?,
    @SerializedName("translations")
    val translations: Translations?,
    @SerializedName("unMember")
    val unMember: Boolean?
) : Parcelable, Serializable