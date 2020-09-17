package ru.test.countriesapp;

import android.app.Application;

import androidx.room.Room;

import ru.test.countriesapp.db.CountryDatabase;

public class App extends Application {

    private static CountryDatabase INSTANCE;

    @Override
    public void onCreate() {
        super.onCreate();
        if (INSTANCE == null) {
            synchronized (this) {
                INSTANCE = Room.databaseBuilder(
                        getApplicationContext(),
                        CountryDatabase.class,
                        "country_database"
                ).build();
            }
        }
    }

    public static CountryDatabase getDatabase() {
        return INSTANCE;
    }
}
