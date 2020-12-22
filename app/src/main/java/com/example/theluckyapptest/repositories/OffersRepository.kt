package com.example.theluckyapptest.repositories

import com.example.theluckyapptest.data.OfferDetails
import com.example.theluckyapptest.data.offersectionsviewtype.OfferSectionViewType

interface OffersRepository {
    suspend fun getOffersSections(): List<OfferSectionViewType>
    suspend fun getOfferDetails(offerUrl: String): OfferDetails
}