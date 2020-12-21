package com.example.theluckyapptest.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.theluckyapptest.R
import com.example.theluckyapptest.data.ErrorScreenData
import com.example.theluckyapptest.data.OfferDetails
import com.example.theluckyapptest.helpers.SingleLiveEvent
import com.example.theluckyapptest.repositories.OffersRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class OfferDetailsViewModel(
    private val repository: OffersRepository,
    offerUrl: String
) : BaseViewModel() {

    private val _offerDetails = MutableLiveData<OfferDetails>()
    val offerDetails: LiveData<OfferDetails> = _offerDetails

    private val _isOfferInvalid = SingleLiveEvent<Boolean>()
    val isOfferInvalid: SingleLiveEvent<Boolean> = _isOfferInvalid

    init {
        if (offerUrl.isNotEmpty()) {
            retrieveOfferDetails(offerUrl)
        } else {
            isOfferInvalid.value = true
        }
    }

    private fun retrieveOfferDetails(offerUrl: String) {
        showLoading.value = true
        viewModelScope.launch(Dispatchers.IO) {
            try {
                _offerDetails.postValue(
                    repository.getOfferDetails(offerUrl)
                )
            } catch (exception: Exception) {
                errorScreenData.postValue(
                    ErrorScreenData(
                        message = R.string.error_occurred_retrieving_offer,
                        retryAction = { retrieveOfferDetails(offerUrl) }
                    )
                )
            } finally {
                showLoading.postValue(false)
            }
        }
    }
}
