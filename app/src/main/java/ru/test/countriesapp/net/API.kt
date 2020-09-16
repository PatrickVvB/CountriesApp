package ru.test.countriesapp.net

import retrofit2.http.GET
import retrofit2.http.Path

interface API {

    @GET("all")
    suspend fun getAll()

    @GET("name/{name}")
    suspend fun getCountryName(@Path ("name") countryName: String)


}