package ru.test.countriesapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import ru.test.countriesapp.R
import ru.test.countriesapp.databinding.ItemCountryBinding
import ru.test.countriesapp.db.model.Country

class CountryRvAdapter() : RecyclerView.Adapter<CountryRvAdapter.VH>() {

    private var countries = emptyList<Country>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(DataBindingUtil.inflate(LayoutInflater.from(parent.context),
            R.layout.item_country, parent, false))
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bindUI(countries[position])
    }

    override fun getItemCount(): Int {
        return countries.size
    }

    fun setCountryList(countries: ArrayList<Country>) {
        this.countries = countries
        notifyDataSetChanged()
    }

    inner class VH(val binding: ItemCountryBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bindUI(country: Country) {
            binding.country = country
        }
    }
}