package ru.test

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import ru.test.countriesapp.net.RetrofitClient

@BindingAdapter("app:imageFromNet")
fun setImageFromNet(iv: ImageView, url: String) {
    Glide.with(iv.context)
        .load(getCorrectImageURI(url))
        .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
        .skipMemoryCache(false)
        .into(iv)
}

fun getCorrectImageURI(uri: String): String {
    return uri.let {
        if (it[0] == '/')
            RetrofitClient.baseUrl + it.substring(1)
        else it
    }
}