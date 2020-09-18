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
import ru.test.countriesapp.db.model.Country
import ru.test.countriesapp.vm.CountryInfoViewModel

/*В пейзажной ориентации вся информация может не влезать на экран
* телефонов из за раз большого размера флага (тк width и height - wrap_content).
* Можно задать размеры картинке или добавить ScrollView*/
class CountryInfoFragment : BaseFragment<CountryInfoViewModel>() {

    lateinit var binding: FragmentCountryInfoBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_country_info, container, false)
        if (!checkVM())
            vm = ViewModelProviders.of(this).get(CountryInfoViewModel::class.java)
        binding.vm = this.vm
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (savedInstanceState != null)
            vm.country.value = savedInstanceState.getSerializable(ACTIVE_FRAGMENT) as Country
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putSerializable(ACTIVE_FRAGMENT, vm.country.value)
    }

    //установка view model
    fun setVM(vm: CountryInfoViewModel) {
        this.vm = vm
    }

    companion object {
        const val ACTIVE_FRAGMENT = "info_fragment"
    }
}