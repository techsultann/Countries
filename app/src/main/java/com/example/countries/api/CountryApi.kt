package com.example.countries.api

import com.example.countries.models.CountriesResponseItem
import retrofit2.Call
import retrofit2.http.GET

interface CountryApi {

    @GET("all")
    fun getCountries(): Call<List<CountriesResponseItem>>
}