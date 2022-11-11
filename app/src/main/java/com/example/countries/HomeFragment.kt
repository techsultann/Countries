package com.example.countries

import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.countries.adapter.CountryAdapter
import com.example.countries.databinding.FragmentHomeBinding
import com.example.countries.repository.CountryRepository

class HomeFragment : Fragment() {

    private lateinit var viewModel: MainViewModel
    private lateinit var countryAdapter: CountryAdapter

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as MainActivity).viewModel
        setUpRecyclerView()

        viewModel.getCountry()
        viewModel.myResponse.observe(viewLifecycleOwner, Observer { _ ->
            countryAdapter.countryList

        })

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root

    }

    private fun setUpRecyclerView() = binding.recyclerView.apply {
        countryAdapter = CountryAdapter()
        binding.recyclerView.apply {
             adapter = countryAdapter
            layoutManager = LinearLayoutManager(activity)
        }

    }




    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}