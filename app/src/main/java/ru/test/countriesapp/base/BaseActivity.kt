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

    //установка фрагмента с тэгом в бек стек
    fun addFragmentWithTag(fragment: BaseFragment<*>) {
        supportFragmentManager
            .beginTransaction()
            .addToBackStack("")
            .replace(R.id.container, fragment, fragment.javaClass.name)
            .commit()
    }

    //замена фрагмента с тэгом
    fun replaceFragmentWithTag(fragment: BaseFragment<*>) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, fragment, fragment.javaClass.name)
            .commit()
    }
}