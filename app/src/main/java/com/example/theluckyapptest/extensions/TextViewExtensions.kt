package com.example.theluckyapptest.extensions

import android.graphics.Paint
import android.widget.TextView

import androidx.databinding.BindingAdapter


@BindingAdapter("strikeThrough")
fun TextView.strikeThrough(strikeThrough: Boolean) {
    if (strikeThrough) {
        this.paintFlags = this.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
    } else {
        this.paintFlags = this.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
    }
}