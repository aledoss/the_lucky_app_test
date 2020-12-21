package com.example.theluckyapptest.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.theluckyapptest.data.offersectionsviewtype.OffersSectionsViewType
import com.example.theluckyapptest.repositories.OffersRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class OffersViewModel(
    private val offersRepository: OffersRepository
) : BaseViewModel() {

    private val _offersSections = MutableLiveData<List<OffersSectionsViewType>>()
    val offerSections: LiveData<List<OffersSectionsViewType>> = _offersSections

    init {
        retrieveOffers()
    }

    private fun retrieveOffers() {
        showLoading.value = true
        viewModelScope.launch(Dispatchers.IO) {
            _offersSections.postValue(offersRepository.getOffersSections())
            showLoading.postValue(false)
        }
    }
}
