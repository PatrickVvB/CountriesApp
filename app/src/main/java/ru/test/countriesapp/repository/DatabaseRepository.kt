package ru.test.countriesapp.repository

import androidx.lifecycle.LiveData
import ru.test.countriesapp.db.CountryDao
import ru.test.countriesapp.db.model.Country

class DatabaseRepository(private val countryDao: CountryDao) {

    val getAllCountry: LiveData<ArrayList<Country>> = countryDao.getAllCountry()

    suspend fun insert(country: ArrayList<Country>) {
        countryDao.insertAllCountry(country)
    }

    suspend fun gerCountryByName(name: String): LiveData<Country> {
        return countryDao.getCountryByName(name)
    }
}