package com.example.countries.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.countries.adapter.CountryAdapter
import com.example.countries.databinding.FragmentHomeBinding
import com.example.countries.viewmodel.CountryViewModel


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var countryViewModel: CountryViewModel
    private lateinit var countryAdapter: CountryAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        countryViewModel = (activity as MainActivity).viewModel

        setUpRecyclerView()


    }


    private fun setUpRecyclerView() {
        countryAdapter = CountryAdapter()

        binding.rvCountry.apply {
            layoutManager = LinearLayoutManager(activity)

            adapter = countryAdapter

            countryViewModel.countryResult().observe(viewLifecycleOwner) { countryList ->

                if (countryList != null) {
                    countryAdapter.differ.submitList(countryList)
                }
            }

        }

        }




    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}