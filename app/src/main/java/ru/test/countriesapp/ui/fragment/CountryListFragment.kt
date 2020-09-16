package ru.test.countriesapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import ru.test.countriesapp.R
import ru.test.countriesapp.base.BaseFragment
import ru.test.countriesapp.databinding.FragmentCountryListBinding
import ru.test.countriesapp.vm.CountryListViewModel

class CountryListFragment : BaseFragment<CountryListViewModel>() {

    lateinit var binding: FragmentCountryListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_country_list, container, false)
        return binding.root
    }
}