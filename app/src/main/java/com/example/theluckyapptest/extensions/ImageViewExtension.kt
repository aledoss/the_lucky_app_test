package com.example.theluckyapptest.extensions

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

@BindingAdapter("imageUrl")
fun ImageView.loadFromUrl(url: String?) {
    url?.let {
        Picasso
            .get()
            .load(url)
            .into(this)
    }
}
