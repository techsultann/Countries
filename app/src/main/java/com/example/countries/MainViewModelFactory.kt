package com.example.countries

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.countries.repository.CountryRepository

@Suppress("UNCHECKED_CAST")
class MainViewModelFactory(
    private val repository: CountryRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }
}