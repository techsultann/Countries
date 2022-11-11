package com.example.countries.repository

import com.example.countries.api.RetrofitInstance
import com.example.countries.model.Post
import retrofit2.Response

class CountryRepository {

    suspend fun getPost(): Response<Post> {
        return RetrofitInstance.api.getPost()
    }
}