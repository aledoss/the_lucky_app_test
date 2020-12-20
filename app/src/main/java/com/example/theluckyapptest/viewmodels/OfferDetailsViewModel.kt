package com.example.theluckyapptest.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.theluckyapptest.repositories.OffersRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class OfferDetailsViewModel(
    private val repository: OffersRepository,
    offerUrl: String
) : ViewModel() {

    init {
        retrieveOfferDetails(offerUrl)
    }

    private fun retrieveOfferDetails(offerUrl: String) {
        viewModelScope.launch(Dispatchers.IO){
            val offerDetails = repository.getOfferDetails(offerUrl)
        }
    }

}