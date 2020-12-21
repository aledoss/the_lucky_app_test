package com.example.theluckyapptest.data

import androidx.annotation.StringRes
import com.example.theluckyapptest.R
import java.io.Serializable

class ErrorScreenData(
    @StringRes val title: Int = R.string.oops,
    @StringRes val message: Int,
    val retryAction: () -> Unit
) : Serializable