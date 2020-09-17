package ru.test.countriesapp.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import ru.test.countriesapp.App
import ru.test.countriesapp.base.BaseViewModel
import ru.test.countriesapp.db.model.Country
import ru.test.countriesapp.repository.CountryListRepository
import ru.test.countriesapp.repository.DatabaseRepository

class CountryListViewModel() : BaseViewModel() {

    private val job = Job()
    private val vmScope = CoroutineScope(Dispatchers.Main + job)

    private val countryDao = App.getDatabase().countryDao()
    private val databaseRep = DatabaseRepository(countryDao)
    private val countryListRep = CountryListRepository()

    //база данных
    val databaseCountries = databaseRep.getAllCountry
    val newCountryList = MutableLiveData<ArrayList<Country>>()

    //вставка списка стран
    private fun insertCountry(country: ArrayList<Country>) {
        viewModelScope.launch(Dispatchers.IO) {
            databaseRep.insert(country)
        }
    }

    //загрузка списка стран
    fun getAllCountries() {
        vmScope.launch {
            val response = countryListRep.getAllCountries()
            if (response.code() < 400) {
                insertCountry(response.body()!!)//расчитывается что какие то данные ТОЧНО придут
                newCountryList.value = response.body()
            }
            else showToast("Возникли проблемы с загрузкой стран, повторите попытку позже")
        }
    }
}