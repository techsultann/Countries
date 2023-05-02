package com.example.countries.models


import com.google.gson.annotations.SerializedName

data class CountriesResponse(
    val countries: List<CountriesResponseItem>
)