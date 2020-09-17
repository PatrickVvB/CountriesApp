package ru.test.countriesapp.ui.activity

import android.os.Bundle
import ru.test.countriesapp.R
import ru.test.countriesapp.base.BaseActivity
import ru.test.countriesapp.ui.fragment.CountryListFragment

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addFragment(CountryListFragment())
    }
}
