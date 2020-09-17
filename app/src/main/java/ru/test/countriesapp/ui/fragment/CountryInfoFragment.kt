package ru.test.countriesapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import ru.test.countriesapp.R
import ru.test.countriesapp.base.BaseFragment
import ru.test.countriesapp.databinding.FragmentCountryInfoBinding
import ru.test.countriesapp.vm.CountryInfoViewModel

class CountryInfoFragment : BaseFragment<CountryInfoViewModel>() {

    lateinit var binding: FragmentCountryInfoBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_country_info, container, false)
        binding.vm = this.vm
        return binding.root
    }

    //установка view model
    fun setVM(vm: CountryInfoViewModel) {
        this.vm = vm
    }
}