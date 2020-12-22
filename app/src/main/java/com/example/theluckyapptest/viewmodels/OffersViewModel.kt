package com.example.theluckyapptest.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.theluckyapptest.R
import com.example.theluckyapptest.data.ErrorScreenData
import com.example.theluckyapptest.data.offersectionsviewtype.OfferSectionViewType
import com.example.theluckyapptest.repositories.OffersRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class OffersViewModel(
    private val offersRepository: OffersRepository
) : BaseViewModel() {

    private val _offersSections = MutableLiveData<List<OfferSectionViewType>>()
    val offerSections: LiveData<List<OfferSectionViewType>> = _offersSections

    private val _offersQuantity = MutableLiveData<Int>()
    val offersQuantity: LiveData<Int> = _offersQuantity

    init {
        retrieveOffers()
    }

    private fun retrieveOffers() {
        showLoading.value = true
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val offersSectionsViewType = offersRepository.getOffersSections()
                _offersSections.postValue(offersSectionsViewType.offersSectionsViewTypes)
                _offersQuantity.postValue(offersSectionsViewType.offersQuantity)
            } catch (exception: Exception) {
                errorScreenData.postValue(
                    ErrorScreenData(
                        message = R.string.error_occurred_retrieving_offers,
                        retryAction = { retrieveOffers() }
                    )
                )
            } finally {
                showLoading.postValue(false)
            }
        }
    }
}
