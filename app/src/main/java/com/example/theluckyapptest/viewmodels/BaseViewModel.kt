package com.example.theluckyapptest.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.theluckyapptest.data.ErrorScreenData
import com.example.theluckyapptest.helpers.SingleLiveEvent

abstract class BaseViewModel : ViewModel() {

    protected val errorScreenData = SingleLiveEvent<ErrorScreenData>()
    val getErrorScreenData: LiveData<ErrorScreenData> = errorScreenData

    protected val showLoading = SingleLiveEvent<Boolean>()
    val getShowLoading: LiveData<Boolean> = showLoading
}
