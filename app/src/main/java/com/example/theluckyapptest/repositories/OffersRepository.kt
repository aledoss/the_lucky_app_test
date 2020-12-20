package com.example.theluckyapptest.repositories

import com.example.theluckyapptest.data.offersectionsviewtype.OffersSectionsViewType

interface OffersRepository {
    fun getOffersSections(): List<OffersSectionsViewType>
}