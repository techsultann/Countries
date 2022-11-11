package com.example.countries.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import androidx.viewbinding.ViewBinding
import com.bumptech.glide.Glide
import com.example.countries.databinding.CountryListItemBinding
import com.example.countries.model.Post

class CountryAdapter : RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {


    inner class CountryViewHolder(val binding: CountryListItemBinding) : ViewHolder(binding.root)

    private val diffCallback = object : DiffUtil.ItemCallback<Post>() {

        override fun areItemsTheSame(oldItem: Post, newItem: Post): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: Post, newItem: Post): Boolean {
            return oldItem == newItem
        }
    }

    private val differ = AsyncListDiffer(this, diffCallback)
    var countryList: List<Post>
        get() = differ.currentList
        set(value) {differ.submitList(value)}



    override fun getItemCount() = countryList.size


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        return CountryViewHolder(CountryListItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        val country = countryList[position]
        holder.binding.apply {
            Glide.with(holder.itemView).load(country.flag).into(ivFlag)

            tvCountry.text = country.name
            tvCapital.text = country.capital

        }
    }

    }

