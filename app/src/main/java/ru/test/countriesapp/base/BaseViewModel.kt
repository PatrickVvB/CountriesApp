package ru.test.countriesapp.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class BaseViewModel : ViewModel() {

    val toastObserver = MutableLiveData<String>()

    fun showToast(msg: String) {
        toastObserver.value = msg
    }
}