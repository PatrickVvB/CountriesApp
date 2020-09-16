package ru.test.countriesapp.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Country(
    @PrimaryKey
    @SerializedName("name")
    val name: String,
    @SerializedName("flag")
    val flag: String,
    @SerializedName("currencies")
    val currency: ArrayList<Currency>,
    @SerializedName("languages")
    val language: ArrayList<Language>,
    @SerializedName("timezones")
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