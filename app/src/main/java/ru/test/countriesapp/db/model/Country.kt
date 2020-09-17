package ru.test.countriesapp.db.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName
import ru.test.countriesapp.db.converters.CurrencyConverter
import ru.test.countriesapp.db.converters.LanguageConverter
import ru.test.countriesapp.db.converters.TimezoneConverter

@Entity
data class Country(
    @PrimaryKey
    @SerializedName("name")
    val name: String,
    @SerializedName("flag")
    val flag: String,
    @SerializedName("currencies")
    @Embedded
    @field:TypeConverters(CurrencyConverter::class)
    val currency: ArrayList<Currency>,
    @SerializedName("languages")
    @Embedded
    @field:TypeConverters(LanguageConverter::class)
    val language: ArrayList<Language>,
    @SerializedName("timezones")
    @field:TypeConverters(TimezoneConverter::class)
    val timeZone: ArrayList<String>
)

data class Currency(
    @SerializedName("code")
    val code: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("symbol")
    val symbol: String
)

data class Language(
    @SerializedName("name")
    val name: String,
    @SerializedName("nativeName")
    val nativeName: String,
    @SerializedName("iso639_1")
    val iso1: String,
    @SerializedName("iso639_2")
    val iso2: String
)