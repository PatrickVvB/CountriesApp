package ru.test.countriesapp.net

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import ru.test.countriesapp.db.model.Country

interface API {

    @GET("all")
    suspend fun getAll(): Response<ArrayList<Country>>

//    @GET("name/{name}")
//    suspend fun getCountryName(@Path ("name") countryName: String): Response<Country>


}