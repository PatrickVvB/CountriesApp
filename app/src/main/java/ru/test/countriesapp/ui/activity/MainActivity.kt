package ru.test.countriesapp.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.test.countriesapp.R
import ru.test.countriesapp.base.BaseActivity

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
