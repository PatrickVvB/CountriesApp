package ru.test.countriesapp.repository

import retrofit2.Response
import ru.test.countriesapp.db.model.Country
import ru.test.countriesapp.net.RetrofitClient

class CountryListRepository {

    //получение списка стран
    suspend fun getAllCountries(): Response<ArrayList<Country>> {
        return RetrofitClient.client.getAll()
    }
}