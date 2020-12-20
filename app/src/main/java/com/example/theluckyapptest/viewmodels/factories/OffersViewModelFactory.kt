package com.example.theluckyapptest.viewmodels.factories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.theluckyapptest.repositories.OffersRepository
import com.example.theluckyapptest.viewmodels.OffersViewModel

class OffersViewModelFactory(private val offersRepository: OffersRepository) :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>) =
        OffersViewModel(offersRepository) as T
}