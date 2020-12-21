package com.example.theluckyapptest.data

import java.io.Serializable

class ErrorScreenData(
    private val title: String,
    private val message: String,
    private val retryAction: () -> Unit
) : Serializable