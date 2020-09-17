package ru.test.countriesapp.db.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import ru.test.countriesapp.db.model.Language

class LanguageConverter {

    private val gson = Gson()

    @TypeConverter
    fun fromCurrency(language: ArrayList<Language>): String {
        return gson.toJson(language)
    }

    @TypeConverter
    fun currencyToString(language: String): ArrayList<Language> {
        val listType = object : TypeToken<List<Language>>() {}.type
        return gson.fromJson(language, listType)
    }
}