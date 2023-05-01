package com.example.countries.models


import com.google.gson.annotations.SerializedName

data class CountriesResponse(
    @SerializedName("countries")
    val countries: List<CountriesResponseItem>
)