package ru.test.countriesapp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ru.test.countriesapp.db.model.Country

@Database(entities = [Country::class], version = 1, exportSchema = false)
abstract class CountryDatabase : RoomDatabase() {

    abstract fun countryDao(): CountryDao

    public fun getDatabase(context: Context): CountryDatabase {
        val tempInstance = INSTANCE
        if (tempInstance != null)
            return tempInstance
        synchronized(this) {
            val instance = Room.databaseBuilder(
                context.applicationContext,
                CountryDatabase::class.java,
                "country_database"
            ).build()
            INSTANCE = instance
            return instance
        }
    }

    companion object {
        @Volatile
        private var INSTANCE: CountryDatabase? = null
    }
}