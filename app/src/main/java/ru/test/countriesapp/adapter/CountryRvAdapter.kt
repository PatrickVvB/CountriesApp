package ru.test.countriesapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import ru.test.countriesapp.R
import ru.test.countriesapp.databinding.ItemCountryBinding
import ru.test.countriesapp.db.model.Country
import ru.test.countriesapp.ui.activity.MainActivity
import ru.test.countriesapp.ui.fragment.CountryInfoFragment
import ru.test.countriesapp.vm.CountryInfoViewModel

class CountryRvAdapter : RecyclerView.Adapter<CountryRvAdapter.VH>() {

    //пустой список стран
    private var countries = ArrayList<Country>()

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

    //установка списка стран
    fun setCountryList(countries: ArrayList<Country>) {
        this.countries.clear()
        this.countries.addAll(countries)
        notifyDataSetChanged()
    }

    inner class VH(val binding: ItemCountryBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bindUI(country: Country) {
            binding.country = country

            //переход в детальную информацию
            binding.cvRoot.setOnClickListener {
                val fragment = CountryInfoFragment()
                val vm: CountryInfoViewModel =
                    ViewModelProviders.of(binding.root.context as MainActivity)
                        .get(CountryInfoViewModel::class.java)
                vm.country.value = country
                fragment.setVM(vm)
                (binding.root.context as MainActivity).addFragmentWithTag(fragment)
            }
        }
    }
}