package com.example.theluckyapptest.viewmodels

import androidx.lifecycle.ViewModel
import com.example.theluckyapptest.repositories.OffersRepository

class OffersViewModel(
    private val offersRepository: OffersRepository
) : ViewModel() {

    init {
        retrieveOffers()
    }

    private fun retrieveOffers() {
        offersRepository.getOffersSections()
    }
}