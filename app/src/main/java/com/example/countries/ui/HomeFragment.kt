package com.example.countries.ui

import android.content.res.Configuration
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.countries.R
import com.example.countries.adapter.CountryAdapter
import com.example.countries.databinding.FragmentHomeBinding
import com.example.countries.viewmodel.CountryViewModel
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


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

        searchCountry()
        setUpRecyclerView()

        binding.imgToggle.setOnClickListener {

            switchDisplayMode()
        }

        binding.ivLanguage.setOnClickListener {
            showBottomDialog()
        }


        countryAdapter.setOnItemClickListener {
            val bundle = Bundle().apply {
                putSerializable("countries" , it)
            }
            findNavController().navigate(R.id.action_homeFragment_to_detailsFragment, bundle)
        }


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

    private fun searchCountry() {
        var job : kotlinx.coroutines.Job? = null
        binding.etSearch.addTextChangedListener{ text ->
            job?.cancel()
            job = MainScope().launch {
                delay(500L);
                text.let {
                    if (text.toString().isNotEmpty())
                        countryViewModel.searchCountry(text.toString())
                }

            }
        }
    }

    fun showBottomDialog() {

        val languageBottomSheetView = layoutInflater.inflate(R.layout.language_bottom_sheet_layout, null)
        val dialog = BottomSheetDialog(requireContext())
        dialog.setTitle("Select a Language")
        dialog.setContentView(languageBottomSheetView)




        dialog.dismiss()
    }

    private fun switchDisplayMode() {

        val isNightTheme = resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK

        if(isNightTheme == Configuration.UI_MODE_NIGHT_YES ) {

            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            binding.imgToggle.setImageResource(R.drawable.ic_light_mode)

        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            binding.imgToggle.setImageResource(R.drawable.ic_dark_mode)

        }
    }




    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}