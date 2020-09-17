package ru.test.countriesapp.base

import androidx.appcompat.app.AppCompatActivity
import ru.test.countriesapp.R

abstract class BaseActivity : AppCompatActivity() {

    //установка фрагмента с добавлением в бек стек
    fun addFragment(fragment: BaseFragment<*>) {
        supportFragmentManager
            .beginTransaction()
            .addToBackStack("")
            .replace(R.id.container, fragment)
            .commit()
    }

    //замена фрагмента
    fun replaceFragment(fragment: BaseFragment<*>) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, fragment)
            .commit()
    }
}