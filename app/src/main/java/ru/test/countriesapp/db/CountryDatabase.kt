package ru.test.countriesapp.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ru.test.countriesapp.db.converters.CurrencyConverter
import ru.test.countriesapp.db.converters.LanguageConverter
import ru.test.countriesapp.db.converters.TimezoneConverter
import ru.test.countriesapp.db.model.Country

@Database(entities = [Country::class], version = 1, exportSchema = false)
@TypeConverters(CurrencyConverter::class, LanguageConverter::class, TimezoneConverter::class)
abstract class CountryDatabase : RoomDatabase() {

    abstract fun countryDao(): CountryDao
}