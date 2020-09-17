package ru.test.countriesapp.vm

import androidx.lifecycle.MutableLiveData
import ru.test.countriesapp.base.BaseViewModel
import ru.test.countriesapp.db.model.Country

class CountryInfoViewModel : BaseViewModel() {

    //выбранная страна для Data Binding-а
    val country = MutableLiveData<Country>()
}