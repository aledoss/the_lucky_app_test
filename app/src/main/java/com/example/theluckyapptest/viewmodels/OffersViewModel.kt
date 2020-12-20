package com.example.theluckyapptest.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.theluckyapptest.data.offersectionsviewtype.OffersSectionsViewType
import com.example.theluckyapptest.repositories.OffersRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class OffersViewModel(
    private val offersRepository: OffersRepository
) : ViewModel() {

    private val _offersSections = MutableLiveData<List<OffersSectionsViewType>>()
    val offerSections: LiveData<List<OffersSectionsViewType>> = _offersSections

    init {
        retrieveOffers()
    }

    private fun retrieveOffers() {
        viewModelScope.launch(Dispatchers.IO) {
            _offersSections.postValue(offersRepository.getOffersSections())
        }
    }
}