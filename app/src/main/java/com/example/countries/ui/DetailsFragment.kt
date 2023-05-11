package com.example.countries.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageSwitcher
import android.widget.ImageView
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.countries.R
import com.example.countries.databinding.FragmentDetailsBinding
import com.example.countries.databinding.FragmentHomeBinding
import com.example.countries.models.CountriesResponse
import com.example.countries.models.CountriesResponseItem
import com.example.countries.viewmodel.CountryViewModel


class DetailsFragment : Fragment() {
    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!
    private lateinit var countryViewModel: CountryViewModel
    private val args: DetailsFragmentArgs by navArgs()
    private lateinit var countryDetails : CountriesResponseItem

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        countryViewModel = (activity as MainActivity).viewModel

        countryDetails = args.countries!!

        binding.imgArrowBack.setOnClickListener {
            findNavController().navigate(DetailsFragmentDirections.actionDetailsFragmentToHomeFragment())
        }

        Glide.with(requireContext())
            .load(countryDetails.flags!!.png)
            .transform(RoundedCorners(7))
            .into(binding.imageView)

        binding.tvCountryName.text = countryDetails.name!!.common
        binding.population.text = countryDetails.population.toString()
        binding.capital.text = countryDetails.capital.toString()
        binding.motto.text = countryDetails.demonyms.toString()
        binding.officialLanguage.text = countryDetails.languages.toString()
        binding.unMember.text = if (countryDetails.unMember == true) "Yes" else "No"
        binding.postalCode.text = countryDetails.postalCode.toString()
        binding.independence.text = if (countryDetails.independent == true) "Yes" else "No"
        binding.area.text = countryDetails.area.toString()
        binding.currency.text = countryDetails.currencies.toString()
        binding.landLocked.text = if (countryDetails.landlocked == true) "Yes" else "No"
        binding.timeZone.text = countryDetails.timezones.toString()



    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}