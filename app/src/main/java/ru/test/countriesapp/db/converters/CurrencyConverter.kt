package ru.test.countriesapp.db.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import ru.test.countriesapp.db.model.Currency

class CurrencyConverter {

    private val gson = Gson()

    @TypeConverter
    fun fromCurrency(currency: ArrayList<Currency>): String {
        val type = object : TypeToken<List<Currency>>() {}.type
        return gson.toJson(currency, type)
    }

    @TypeConverter
    fun currencyToString(currency: String): ArrayList<Currency> {
        val listType = object : TypeToken<List<Currency>>() {}.type
        return gson.fromJson(currency, listType)
    }
}