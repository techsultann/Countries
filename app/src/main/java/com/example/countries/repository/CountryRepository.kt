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
    private val searchCountryLiveData : MutableLiveData<List<CountriesResponseItem>?> = MutableLiveData()


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
                         val sorted = response.body()!!.sortedBy { it.name!!.common }
                         countryLiveData.postValue(sorted)

                     }

                 }

                 override fun onFailure(call: Call<List<CountriesResponseItem>>, t: Throwable) {
                     countryLiveData.postValue(null)
                 }


             }

         )

    }

    fun searchCountry(query: String) {

        countryService.searchCountry(query).enqueue(
            object : Callback<List<CountriesResponseItem>> {
                override fun onResponse(
                    call: Call<List<CountriesResponseItem>>,
                    response: Response<List<CountriesResponseItem>>
                ) {
                    if (response.isSuccessful) {

                        searchCountryLiveData.postValue(response.body())


                    } else {
                        // Handle error response
                    }
                }


                override fun onFailure(call: Call<List<CountriesResponseItem>>, t: Throwable) {
                    // Handle network failure
                    searchCountryLiveData.postValue(null)
                }

            }
        )
    }


    fun getCountryResultLiveData() : MutableLiveData<List<CountriesResponseItem>?> {
        return countryLiveData

    }

    fun searchCountryLiveData() : MutableLiveData<List<CountriesResponseItem>?> {
        return countryLiveData
    }
}