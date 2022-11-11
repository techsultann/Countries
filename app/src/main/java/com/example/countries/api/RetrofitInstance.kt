package com.example.countries.api

import com.example.countries.utils.Constant.Companion.BASE_URL
import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {


    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: CountryApi by lazy {
        retrofit.create(CountryApi::class.java)
    }
}