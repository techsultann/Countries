package com.example.countries.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.countries.api.RetrofitInstance
import com.example.countries.models.CountriesResponse
import com.example.countries.models.CountriesResponseItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CountryRepository {

    private val  countryService = RetrofitInstance.api
    private val countryLiveData : MutableLiveData<CountriesResponseItem?> = MutableLiveData()


    init {
        getCountryList()
    }
     private fun getCountryList() {

         countryService.getCountries().enqueue(
             object : Callback<CountriesResponseItem> {
                 override fun onResponse(
                     call: Call<CountriesResponseItem>,
                     response: Response<CountriesResponseItem>
                 ) {
                     if (response.body() != null) {
                         countryLiveData.postValue(response.body())

                     }

                 }

                 override fun onFailure(call: Call<CountriesResponseItem>, t: Throwable) {
                     countryLiveData.postValue(null)
                 }


             }

         )

    }

    fun getCountryResultLiveData() : MutableLiveData<CountriesResponseItem?> {
        return countryLiveData

    }
}