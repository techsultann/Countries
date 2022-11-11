package com.example.countries.api

import com.example.countries.model.Post
import retrofit2.Response
import retrofit2.http.GET

interface CountryApi {

    @GET("v3.1/all")
    fun getPost(): Response<Post>
}