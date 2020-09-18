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

    private lateinit var binding: FragmentCountryListBinding
    private var mAdapter: CountryRvAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_country_list, container, false)
        if (!checkVM())
            vm = ViewModelProviders.of(this).get(CountryListViewModel::class.java)
        initObserver()
        initCountryList()
        binding.tvBtnUpdateList.setOnClickListener { vm.getAllCountries() }
        return binding.root
    }

    /*Проверка, если бд пуста, начинается загрузка из сети.
    Так же можно проверять на наличие интернета.*/
    private fun initCountryList() {
        vm.databaseCountries.value?.let {
            initRecycler(it as ArrayList<Country>)
        } ?: vm.getAllCountries()
    }

    //установка recyclerview
    private fun initRecycler(countries: ArrayList<Country>) {
        binding.rvCountries.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            mAdapter = CountryRvAdapter().apply { setCountryList(countries) }
            adapter = mAdapter
        }
    }

    //при получении нового списка или обновляет адаптер или устанавливает новый
    private fun initObserver() {
        vm.databaseCountries.observe(this, Observer {
            it?.let {
                initRecycler(it as ArrayList<Country>)
            } ?: return@Observer
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        if (checkVM())
            vm.databaseCountries.removeObservers(this)
    }
}