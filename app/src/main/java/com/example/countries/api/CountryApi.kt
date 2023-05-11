package com.example.countries.api

import com.example.countries.models.CountriesResponseItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface CountryApi {

    @GET("all")
    fun getCountries(): Call<List<CountriesResponseItem>>

    @GET("all")
    fun searchCountry(
        @Query("search") query: String) : Call<List<CountriesResponseItem>>

}