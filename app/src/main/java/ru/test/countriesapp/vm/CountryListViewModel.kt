package ru.test.countriesapp.vm

import android.app.Application
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import ru.test.countriesapp.base.BaseViewModel
import ru.test.countriesapp.db.CountryDatabase
import ru.test.countriesapp.repository.CountryListRepository
import ru.test.countriesapp.repository.CountryRepository

class CountryListViewModel(application: Application) : BaseViewModel() {

    private val job = Job()
    val vmScope = CoroutineScope(Dispatchers.Main + job)

//    private val countryDao = CountryDatabase.getDatabase(application).countryDao()
//    private val countryRep = CountryRepository(countryDao)
//    val allCountries = countryRep.allCountry

    private val countryListRep = CountryListRepository()



}