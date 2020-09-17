package ru.test.countriesapp.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ru.test.countriesapp.db.model.Country

@Dao
interface CountryDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAllCountry(country: List<Country>)

    @Query("SELECT * FROM country WHERE name = :countryName")
    fun getCountryByName(countryName: String): LiveData<Country>

    @Query("SELECT * FROM country ORDER BY name ASC")
    fun getAllCountry(): LiveData<List<Country>>
}