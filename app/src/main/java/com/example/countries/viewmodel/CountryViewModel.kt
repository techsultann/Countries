package com.example.countries.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.example.countries.repository.CountryRepository
import kotlinx.coroutines.launch
import retrofit2.Response


class CountryViewModel(
    application: Application,
    private val repository: CountryRepository
    ) : AndroidViewModel(application) {


        fun countryResult() = repository.getCountryResultLiveData()


}