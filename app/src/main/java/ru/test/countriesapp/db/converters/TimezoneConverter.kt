package ru.test.countriesapp.db.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class TimezoneConverter {

    private val gson = Gson()

    @TypeConverter
    fun fromCurrency(time: ArrayList<String>): String {
        return gson.toJson(time)
    }

    @TypeConverter
    fun currencyToString(time: String): ArrayList<String> {
        val listType = object : TypeToken<List<String>>() {}.type
        return gson.fromJson(time, listType)
    }
}