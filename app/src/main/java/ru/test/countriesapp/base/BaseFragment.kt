package ru.test.countriesapp.base

import androidx.fragment.app.Fragment

abstract class BaseFragment<T : BaseViewModel> : Fragment() {

    lateinit var vm: T
}