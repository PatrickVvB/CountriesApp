package ru.test.countriesapp.net

import retrofit2.Response
import retrofit2.http.GET
import ru.test.countriesapp.db.model.Country

interface API {

    //получение списка стран
    @GET("all")
    suspend fun getAll(): Response<ArrayList<Country>>
}