package com.example.countries.adapter

import android.view.LayoutInflater
import android.view.RoundedCorner
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.countries.databinding.CountryListItemBinding
import com.example.countries.models.CountriesResponse
import com.example.countries.models.CountriesResponseItem
import com.example.countries.ui.HomeFragmentDirections
import java.util.logging.Filter
import java.util.logging.LogRecord


class CountryAdapter : RecyclerView.Adapter<CountryAdapter.CountryViewHolder>()  {

    inner class CountryViewHolder(val binding: CountryListItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    private val differCallBack = object : DiffUtil.ItemCallback<CountriesResponseItem>() {

        override fun areItemsTheSame(oldItem: CountriesResponseItem, newItem: CountriesResponseItem): Boolean {
            return oldItem.name?.official == newItem.name?.official
        }

        override fun areContentsTheSame(oldItem: CountriesResponseItem, newItem: CountriesResponseItem): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallBack)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        return CountryViewHolder(CountryListItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        val country = differ.currentList[position]

        holder.binding.apply {

            Glide.with(holder.itemView)
                .load(country.flags?.png)
                .transform(RoundedCorners(7))
                .into(ivFlag)

            tvCountryName.text = country.name?.common.toString()
            tvCapital.text = country.capital.toString()

        }

        holder.itemView.setOnClickListener { mView ->

            mView.findNavController().
            navigate(HomeFragmentDirections.actionHomeFragmentToDetailsFragment(country))

            }
        }

    private  var onItemClickListener:((CountriesResponseItem) -> Unit)? = null

    fun setOnItemClickListener(listener : (CountriesResponseItem) -> Unit) {
        onItemClickListener = listener
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }


}

