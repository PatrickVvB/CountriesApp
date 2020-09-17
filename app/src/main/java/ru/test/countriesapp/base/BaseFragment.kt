package ru.test.countriesapp.base

import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer

abstract class BaseFragment<T : BaseViewModel> : Fragment() {

    lateinit var vm: T

    override fun onStart() {
        super.onStart()
        initToastObserver()
    }

    //слушатель тоста
    private fun initToastObserver() {
        vm.toastObserver.observe(this, Observer {
            it?.let {
                showToast(it)
            } ?: return@Observer
        })
        vm.toastObserver.value = null
    }

    protected fun showToast(msg: String) {
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        vm.toastObserver.removeObservers(this)
    }
}