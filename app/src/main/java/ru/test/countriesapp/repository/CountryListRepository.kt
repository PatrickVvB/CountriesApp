package ru.test.countriesapp.repository

import retrofit2.Response
import ru.test.countriesapp.db.model.Country
import ru.test.countriesapp.net.RetrofitClient

class CountryListRepository {

    suspend fun getAllCountries(): Response<ArrayList<Country>> {
        return RetrofitClient.client.getAll()
    }
}