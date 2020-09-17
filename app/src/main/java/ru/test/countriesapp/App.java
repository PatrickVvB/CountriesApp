package ru.test.countriesapp;

import android.app.Application;

import androidx.room.Room;

import ru.test.countriesapp.db.CountryDatabase;

public class App extends Application {

    /*
    * создание и получение экземпляра базы данных, создана тут,
    * чтобы не передавать во view model application или context
    */
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
