package com.example.countries.repository

import androidx.lifecycle.MutableLiveData
import com.example.countries.api.RetrofitInstance
import com.example.countries.models.CountriesResponseItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CountryRepository {

    private val  countryService = RetrofitInstance.api
    private val countryLiveData : MutableLiveData<List<CountriesResponseItem>?> = MutableLiveData()


    init {
        getCountryList()
    }
     private fun getCountryList() {

         countryService.getCountries().enqueue(
             object : Callback<List<CountriesResponseItem>> {
                 override fun onResponse(
                     call: Call<List<CountriesResponseItem>>,
                     response: Response<List<CountriesResponseItem>>
                 ) {
                     if (response.body() != null) {
                         countryLiveData.postValue(response.body())

                     }

                 }

                 override fun onFailure(call: Call<List<CountriesResponseItem>>, t: Throwable) {
                     countryLiveData.postValue(null)
                 }


             }

         )

    }

    fun getCountryResultLiveData() : MutableLiveData<List<CountriesResponseItem>?> {
        return countryLiveData

    }
}