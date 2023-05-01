package com.example.countries.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.countries.repository.CountryRepository

@Suppress("UNCHECKED_CAST")
class CountryMainViewModelFactory(
    private val app: Application,
    private val repository: CountryRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CountryViewModel(app, repository) as T
    }
}