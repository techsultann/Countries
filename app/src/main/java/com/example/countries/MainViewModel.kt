package com.example.countries

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.countries.model.Post
import com.example.countries.repository.CountryRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: CountryRepository) : ViewModel() {

    val myResponse: MutableLiveData<Response<Post>> = MutableLiveData()

    fun getCountry() {
        viewModelScope.launch {
            val response = repository.getPost()
            myResponse.value = response

        }
    }
}