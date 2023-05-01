package com.example.countries.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.example.countries.R
import com.example.countries.databinding.ActivityMainBinding
import com.example.countries.repository.CountryRepository
import com.example.countries.viewmodel.CountryMainViewModelFactory
import com.example.countries.viewmodel.CountryViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
     lateinit var viewModel: CountryViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val repository = CountryRepository()
        val viewModelFactory = CountryMainViewModelFactory(application, repository)
        viewModel = ViewModelProvider(this, viewModelFactory)[CountryViewModel::class.java]


        val navHostFragment = supportFragmentManager.findFragmentById(R.id.my_nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

    }

}