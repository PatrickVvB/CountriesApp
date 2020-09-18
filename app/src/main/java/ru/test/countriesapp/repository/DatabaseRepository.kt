package ru.test.countriesapp.repository

import androidx.lifecycle.LiveData
import ru.test.countriesapp.db.CountryDao
import ru.test.countriesapp.db.model.Country

class DatabaseRepository(private val countryDao: CountryDao) {

    //список стран в базе данных
    val getAllCountry: LiveData<List<Country>> = countryDao.getAllCountry()

    //вставка списка стран
    suspend fun insert(country: List<Country>) {
        countryDao.insertAllCountry(country)
    }
}