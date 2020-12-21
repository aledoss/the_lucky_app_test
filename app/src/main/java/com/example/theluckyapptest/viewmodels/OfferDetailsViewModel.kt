package com.example.theluckyapptest.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.theluckyapptest.data.OfferDetails
import com.example.theluckyapptest.repositories.OffersRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class OfferDetailsViewModel(
    private val repository: OffersRepository,
    offerUrl: String
) : BaseViewModel() {

    private val _offerDetails = MutableLiveData<OfferDetails>()
    val offerDetails: LiveData<OfferDetails> = _offerDetails

    init {
        retrieveOfferDetails(offerUrl)
    }

    private fun retrieveOfferDetails(offerUrl: String) {
        showLoading.value = true
        viewModelScope.launch(Dispatchers.IO) {
            repository.getOfferDetails(offerUrl)
                .also {
                    _offerDetails.postValue(it)
                }
            showLoading.postValue(false)
        }
    }

}
