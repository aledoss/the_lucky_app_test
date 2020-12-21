package com.example.theluckyapptest.extensions

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso
import com.squareup.picasso.Transformation

@BindingAdapter("imageUrl")
fun ImageView.loadFromUrl(url: String?) {
    url?.let {
        Picasso
            .get()
            .load(url)
            .into(this)
    }
}

fun ImageView.loadFromUrl(url: String?, transformation: Transformation) {
    url?.let {
        Picasso
            .get()
            .load(url)
            .transform(transformation)
            .into(this)
    }
}
