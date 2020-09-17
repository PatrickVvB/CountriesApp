package ru.test.countriesapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import ru.test.countriesapp.R
import ru.test.countriesapp.adapter.CountryRvAdapter
import ru.test.countriesapp.base.BaseFragment
import ru.test.countriesapp.databinding.FragmentCountryListBinding
import ru.test.countriesapp.db.model.Country
import ru.test.countriesapp.vm.CountryListViewModel

class CountryListFragment : BaseFragment<CountryListViewModel>() {

    lateinit var binding: FragmentCountryListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_country_list, container, false)
        vm = ViewModelProviders.of(this).get(CountryListViewModel::class.java)
        initObserver()
        initCountryList()
        return binding.root
    }

    private fun initCountryList() {
        if (vm.databaseCountries.value!!.isEmpty())
            vm.getAllCountries()
        else initRecycler(vm.databaseCountries.value!!)
    }

    private fun initRecycler(countries: ArrayList<Country>) {
        binding.rvCountries.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = CountryRvAdapter().apply { setCountryList(countries) }
        }
    }

    private fun initObserver() {
        vm.newCountryList.observe(this, Observer {
            it?.let {
                initRecycler(it)
            } ?: return@Observer
        })

    }

    override fun onDestroy() {
        super.onDestroy()
        vm.newCountryList.removeObservers(this)
    }
}