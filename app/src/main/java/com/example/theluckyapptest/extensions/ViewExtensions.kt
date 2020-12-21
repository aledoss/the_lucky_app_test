package com.example.theluckyapptest.extensions

import android.view.View

fun View.show(): View {
    if (visibility != View.VISIBLE) {
        visibility = View.VISIBLE
    }
    return this
}

fun View.hide(): View {
    if (visibility != View.GONE) {
        visibility = View.GONE
    }
    return this
}

fun View.show(show: Boolean): View {
    if (show) {
        this.show()
    } else {
        this.hide()
    }
    return this
}