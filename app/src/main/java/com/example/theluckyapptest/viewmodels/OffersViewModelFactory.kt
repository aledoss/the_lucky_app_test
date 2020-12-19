package com.example.theluckyapptest.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.theluckyapptest.repositories.OffersRepository

class OffersViewModelFactory(private val offersRepository: OffersRepository) :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>) =
        OffersViewModel(offersRepository) as T
}