package com.example.theluckyapptest.viewmodels.factories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.theluckyapptest.repositories.OffersRepository
import com.example.theluckyapptest.viewmodels.OfferDetailsViewModel

class OfferDetailsViewModelFactory(
    private val offerUrl: String,
    private val offersRepository: OffersRepository
) :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>) =
        OfferDetailsViewModel(offersRepository, offerUrl) as T
}