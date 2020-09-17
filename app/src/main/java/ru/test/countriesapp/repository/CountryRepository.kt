package ru.test.countriesapp.repository

import androidx.lifecycle.LiveData
import ru.test.countriesapp.db.CountryDao
import ru.test.countriesapp.db.model.Country

class CountryRepository(private val countryDao: CountryDao) {

    val allCountry: LiveData<ArrayList<Country>> = countryDao.getAllCountry()

    suspend fun insert(country: Country) {
        countryDao.insertCountry(country)
    }

    suspend fun gerCountryByName(name: String): LiveData<Country> {
        return countryDao.getCountryByName(name)
    }
}